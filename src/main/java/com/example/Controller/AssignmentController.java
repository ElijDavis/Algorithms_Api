package com.example.Controller;

import com.example.Assignments.assignment4.service.Max2ndMax;
import com.example.Assignments.assignment4.service.Problem1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem1")
public class AssignmentController {

    private final Problem1 problem1 = new Problem1();

    @GetMapping("/run-json")
    public Max2ndMax runJson(@RequestParam String input) {
        return problem1.solveJson(input);
    }


}

