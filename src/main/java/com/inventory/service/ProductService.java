package com.inventory.service;

import com.inventory.dto.ProductRequest;
import com.inventory.entity.Product;
import com.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AlertService alertService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));
    }

    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findLowStockProducts();
    }

    public List<Product> getOutOfStockProducts() {
        return productRepository.findOutOfStockProducts();
    }

    @Transactional
    public Product createProduct(ProductRequest request) {
        if (productRepository.existsBySku(request.getSku())) {
            throw new RuntimeException("Product with SKU already exists: " + request.getSku());
        }

        Product product = new Product();
        product.setName(request.getName());
        product.setSku(request.getSku());
        product.setSupplier(request.getSupplier());
        product.setQuantity(request.getQuantity());
        product.setMinThreshold(request.getMinThreshold());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setUnit(request.getUnit() != null ? request.getUnit() : "pieces");

        Product savedProduct = productRepository.save(product);
        
        // Check if alert should be triggered
        alertService.checkAndCreateAlert(savedProduct);
        
        return savedProduct;
    }

    @Transactional
    public Product updateProduct(Long id, ProductRequest request) {
        Product product = getProductById(id);

        product.setName(request.getName());
        product.setSupplier(request.getSupplier());
        product.setQuantity(request.getQuantity());
        product.setMinThreshold(request.getMinThreshold());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setUnit(request.getUnit());

        Product updatedProduct = productRepository.save(product);
        
        // Check if alert should be triggered
        alertService.checkAndCreateAlert(updatedProduct);
        
        return updatedProduct;
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Transactional
    public Product updateStock(Long id, Integer quantity) {
        Product product = getProductById(id);
        product.setQuantity(product.getQuantity() + quantity);
        
        Product updatedProduct = productRepository.save(product);
        
        // Check if alert should be triggered
        alertService.checkAndCreateAlert(updatedProduct);
        
        return updatedProduct;
    }
}
