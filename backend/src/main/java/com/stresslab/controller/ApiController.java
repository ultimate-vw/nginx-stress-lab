package com.stresslab.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/ping")
    public String ping() {
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

