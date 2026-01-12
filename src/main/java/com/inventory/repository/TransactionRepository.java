package com.inventory.repository;

import com.inventory.entity.Transaction;
import com.inventory.entity.Transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByProductId(Long productId);
    List<Transaction> findByUserId(Long userId);
    List<Transaction> findByType(TransactionType type);
    
    @Query("SELECT t FROM Transaction t WHERE t.timestamp BETWEEN :startDate AND :endDate")
    List<Transaction> findByTimestampBetween(
        @Param("startDate") LocalDateTime startDate, 
        @Param("endDate") LocalDateTime endDate
    );
    
    @Query("SELECT t FROM Transaction t WHERE t.product.id = :productId AND t.timestamp BETWEEN :startDate AND :endDate")
    List<Transaction> findByProductIdAndTimestampBetween(
        @Param("productId") Long productId,
        @Param("startDate") LocalDateTime startDate, 
        @Param("endDate") LocalDateTime endDate
    );
}
