package com.inventory.repository;

import com.inventory.entity.Alert;
import com.inventory.entity.Alert.AlertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByProductId(Long productId);
    List<Alert> findByTriggered(Boolean triggered);
    List<Alert> findByAlertType(AlertType alertType);
    List<Alert> findByProductIdAndTriggeredTrue(Long productId);
}
