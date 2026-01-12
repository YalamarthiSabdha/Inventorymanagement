package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InventoryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
        System.out.println("==============================================");
        System.out.println("Smart Inventory Management System Started!");
        System.out.println("Server running on: http://localhost:8080");
        System.out.println("==============================================");
    }
}
