package com.inventory.service;

import com.inventory.dto.TransactionRequest;
import com.inventory.entity.Product;
import com.inventory.entity.Transaction;
import com.inventory.entity.User;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.TransactionRepository;
import com.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlertService alertService;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public List<Transaction> getTransactionsByProduct(Long productId) {
        return transactionRepository.findByProductId(productId);
    }

    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByTimestampBetween(startDate, endDate);
    }

    @Transactional
    public Transaction createTransaction(TransactionRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Transaction transaction = new Transaction();
        transaction.setProduct(product);
        transaction.setUser(user);
        transaction.setType(Transaction.TransactionType.valueOf(request.getType().toUpperCase()));
        transaction.setQuantity(request.getQuantity());
        transaction.setPrice(request.getPrice() != null ? request.getPrice() : product.getPrice());
        transaction.setNotes(request.getNotes());

        // Update product stock based on transaction type
        switch (transaction.getType()) {
            case PURCHASE:
                product.setQuantity(product.getQuantity() + request.getQuantity());
                break;
            case SALE:
                if (product.getQuantity() < request.getQuantity()) {
                    throw new RuntimeException("Insufficient stock for sale");
                }
                product.setQuantity(product.getQuantity() - request.getQuantity());
                break;
            case ADJUSTMENT:
                product.setQuantity(request.getQuantity());
                break;
        }

        productRepository.save(product);
        Transaction savedTransaction = transactionRepository.save(transaction);
        
        // Check if alert should be triggered after stock change
        alertService.checkAndCreateAlert(product);
        
        return savedTransaction;
    }

    public List<Transaction> getTransactionHistory(Long productId, LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate != null && endDate != null) {
            return transactionRepository.findByProductIdAndTimestampBetween(productId, startDate, endDate);
        }
        return transactionRepository.findByProductId(productId);
    }
}
