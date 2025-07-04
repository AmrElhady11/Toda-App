package com.TodaApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("todo")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "app is running successfully";
    }
}
