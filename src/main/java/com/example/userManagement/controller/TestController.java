package com.example.userManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Backend is running!";
    }

    @GetMapping("/api/test")
    public String apiTest() {
        return "API works!";
    }
}
