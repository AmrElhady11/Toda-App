package com.authApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Testing")
@RequestMapping("auth")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "app is running successfully";
    }
}
