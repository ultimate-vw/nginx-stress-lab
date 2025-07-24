package com.stresslab.controller;

import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    @GetMapping("/ping")
    public String ping() {
        logger.info("Received GET /api/ping");
        return "pong";
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("Sumit", "Alice", "Bob");
    }

    @PostMapping("/user")
    public Map<String, Object> createUser(@RequestBody Map<String, Object> payload) {
        return Map.of("received", payload);
    }
}

