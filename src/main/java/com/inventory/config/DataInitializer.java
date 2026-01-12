package com.inventory.config;

import com.inventory.entity.Product;
import com.inventory.entity.User;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Users will register themselves - no default users created
        System.out.println("✓ Application started - Users can register via /api/auth/register");

        // Create sample products if database is empty
        if (productRepository.count() == 0) {
            createSampleProduct("Widget A", "SKU-03456", "ABC Supplies", 50, 10, new BigDecimal("25.99"), "Electronics", "pieces");
            createSampleProduct("Gadget B", "SKU-78912", "XYZ Corp", 15, 20, new BigDecimal("45.50"), "Electronics", "pieces");
            createSampleProduct("Tool C", "SKU-34678", "Tools Inc", 8, 15, new BigDecimal("89.99"), "Tools", "pieces");
            createSampleProduct("Device D", "SKU-90234", "Tech Supplies", 0, 10, new BigDecimal("120.00"), "Electronics", "pieces");
            createSampleProduct("Component E", "SKU-56789", "Parts Ltd", 100, 25, new BigDecimal("5.99"), "Components", "pieces");
            
            System.out.println("✓ Sample products created");
        }
    }

    private void createSampleProduct(String name, String sku, String supplier, int quantity, 
                                     int minThreshold, BigDecimal price, String category, String unit) {
        Product product = new Product();
        product.setName(name);
        product.setSku(sku);
        product.setSupplier(supplier);
        product.setQuantity(quantity);
        product.setMinThreshold(minThreshold);
        product.setPrice(price);
        product.setCategory(category);
        product.setUnit(unit);
        productRepository.save(product);
    }
}
