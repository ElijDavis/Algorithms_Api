package com.example.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    // 🚀 Since this class has NO @RequestMapping at the top,
    // these map to the absolute root paths!
    @GetMapping(value = {"/", "/health"})
    public ResponseEntity<String> absoluteRootHealthCheck() {
        return ResponseEntity.ok("OK");
    }
}