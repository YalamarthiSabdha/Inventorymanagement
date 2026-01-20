package com.inventory.controller;

import com.inventory.entity.User;
import com.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        
        List<Map<String, Object>> userList = users.stream()
            .map(user -> {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("id", user.getId());
                userMap.put("username", user.getUsername());
                userMap.put("email", user.getEmail());
                userMap.put("role", user.getRole().toString());
                userMap.put("createdAt", user.getCreatedAt());
                return userMap;
            })
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/employees")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllEmployees() {
        List<User> employees = userRepository.findByRole(User.Role.EMPLOYEE);
        
        List<Map<String, Object>> employeeList = employees.stream()
            .map(user -> {
                Map<String, Object> userMap = new HashMap<>();
                userMap.put("id", user.getId());
                userMap.put("username", user.getUsername());
                userMap.put("email", user.getEmail());
                userMap.put("role", user.getRole().toString());
                userMap.put("createdAt", user.getCreatedAt());
                return userMap;
            })
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(employeeList);
    }
}
