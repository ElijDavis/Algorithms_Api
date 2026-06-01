package com.example.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    // 🚀 Maps to the standard root or /health path that ALB Target Groups look for
    @GetMapping("/")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("OK");
    }
}