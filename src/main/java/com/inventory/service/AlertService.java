package com.inventory.service;

import com.inventory.entity.Alert;
import com.inventory.entity.Product;
import com.inventory.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getActiveAlerts() {
        return alertRepository.findByTriggered(true);
    }

    public List<Alert> getAlertsByProduct(Long productId) {
        return alertRepository.findByProductId(productId);
    }

    @Transactional
    public void checkAndCreateAlert(Product product) {
        // Check if there's already an active alert for this product
        List<Alert> existingAlerts = alertRepository.findByProductIdAndTriggeredTrue(product.getId());
        
        if (product.getQuantity() == 0) {
            // Out of stock
            if (existingAlerts.isEmpty() || 
                existingAlerts.stream().noneMatch(a -> a.getAlertType() == Alert.AlertType.OUT_OF_STOCK)) {
                createAlert(product, Alert.AlertType.OUT_OF_STOCK, 
                    "Product " + product.getName() + " is out of stock!");
            }
        } else if (product.getQuantity() < product.getMinThreshold()) {
            // Low stock
            if (existingAlerts.isEmpty() || 
                existingAlerts.stream().noneMatch(a -> a.getAlertType() == Alert.AlertType.LOW_STOCK)) {
                createAlert(product, Alert.AlertType.LOW_STOCK, 
                    "Product " + product.getName() + " is running low! Current stock: " + product.getQuantity());
            }
        } else {
            // Resolve existing alerts if stock is back to normal
            for (Alert alert : existingAlerts) {
                alert.setTriggered(false);
                alert.setResolvedAt(LocalDateTime.now());
                alertRepository.save(alert);
            }
        }
    }

    private void createAlert(Product product, Alert.AlertType alertType, String message) {
        Alert alert = new Alert();
        alert.setProduct(product);
        alert.setAlertType(alertType);
        alert.setTriggered(true);
        alert.setMessage(message);
        alertRepository.save(alert);
    }

    @Transactional
    public void resolveAlert(Long alertId) {
        Alert alert = alertRepository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setTriggered(false);
        alert.setResolvedAt(LocalDateTime.now());
        alertRepository.save(alert);
    }

    // Scheduled task to check for low stock items every hour
    @Scheduled(cron = "0 0 * * * *")
    public void scheduledAlertCheck() {
        // This would be implemented to periodically check all products
        // For now, alerts are created when products are updated
    }
}
