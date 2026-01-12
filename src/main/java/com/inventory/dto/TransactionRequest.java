package com.inventory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    @NotNull(message = "Product ID is required")
    private Long productId;
    
    @NotNull(message = "Transaction type is required")
    private String type; // PURCHASE, SALE, ADJUSTMENT
    
    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;
    
    private BigDecimal price;
    private String notes;
}
