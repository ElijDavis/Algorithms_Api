package com.example.assignment4.controller;

import com.example.assignment4.service.Max2ndMax;
import com.example.assignment4.service.Problem1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem1")
public class Problem1Controller {

    private final Problem1 problem1 = new Problem1();

    @GetMapping("/run-json")
    public Max2ndMax runJson(@RequestParam String input) {
        return problem1.solveJson(input);
    }


}

