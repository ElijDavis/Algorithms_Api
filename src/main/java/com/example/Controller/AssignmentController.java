package com.example.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.Assignments.assignment4.service.Max2ndMax;
import com.example.Assignments.def.CGraph;
import com.example.Assignments.def.DFSGraph;
import com.example.Assignments.Assignment6.service.Graph;

@RestController
@RequestMapping("/api")
public class AssignmentController {

    // Assignment 2
    @GetMapping("/assignment2/problem1")
    public boolean assignment2Problem1(@RequestParam String input) {
        com.example.Assignments.Assignment2.service.Problem1 problem =
                new com.example.Assignments.Assignment2.service.Problem1();
        return problem.found(input);
    }

    @GetMapping("/assignment2/problem2")
    public int assignment2Problem2(@RequestParam String input) {
        com.example.Assignments.Assignment2.service.Problem2 problem =
                new com.example.Assignments.Assignment2.service.Problem2();
        return problem.count_(input);
    }

    @GetMapping("/assignment2/problem3")
    public double assignment2Problem3(@RequestParam String input) {
        com.example.Assignments.Assignment2.service.Problem3 problem =
                new com.example.Assignments.Assignment2.service.Problem3();
        return problem.sqrt(input);
    }

    // Assignment 3
    @GetMapping("/assignment3/problem1")
    public int assignment3Problem1(@RequestParam String input) {
        com.example.Assignments.Assignment3.service.Problem1 problem =
                new com.example.Assignments.Assignment3.service.Problem1();
        return problem.biggie(input);
    }

    @GetMapping("/assignment3/problem2")
    public int assignment3Problem2(@RequestParam String input) {
        com.example.Assignments.Assignment3.service.Problem2 problem =
                new com.example.Assignments.Assignment3.service.Problem2();
        return problem.Count_(input);
    }

    // Assignment 4
    @GetMapping("/assignment4/problem1")
    public Max2ndMax assignment4Problem1(@RequestParam String input) {
        com.example.Assignments.assignment4.service.Problem1 problem =
                new com.example.Assignments.assignment4.service.Problem1();
        return problem.solveJson(input);
    }

    // Assignment 5
    @GetMapping("/assignment5/problem1/union")
    public int[] assignment5Problem1Union(@RequestParam String input) {
        com.example.Assignments.Assignment5.service.Problem1 problem =
                new com.example.Assignments.Assignment5.service.Problem1();
        return problem.union_(input);
    }

    @GetMapping("/assignment5/problem1/intersection")
    public int[] assignment5Problem1Intersection(@RequestParam String input) {
        com.example.Assignments.Assignment5.service.Problem1 problem =
                new com.example.Assignments.Assignment5.service.Problem1();
        return problem.intersection_(input);
    }

    @GetMapping("/assignment5/problem2")
    public int[] assignment5Problem2(@RequestParam String input) {
        com.example.Assignments.Assignment5.service.Problem2 problem =
                new com.example.Assignments.Assignment5.service.Problem2();
        return problem.threeWayPartition(input);
    }

    // Assignment 6
    @PostMapping("/assignment6/problem1/createGraph")
    public Graph assignment6Problem1CreateGraph(@RequestBody CGraph input) {
        com.example.Assignments.Assignment6.service.Graph problem =
                new com.example.Assignments.Assignment6.service.Graph();
        return problem.createGraph(input);
    }

    @PostMapping("/assignment6/problem1/DFS")
    public String assignment6Problem1DFS(@RequestBody DFSGraph input) {
        com.example.Assignments.Assignment6.service.Graph problem =
                new com.example.Assignments.Assignment6.service.Graph();
        return problem.DFS(input);
    }

    @PostMapping("/assignment6/problem1/getAdjacencyList")
    public String assignment6Problem1AdjacencyList(@RequestBody Graph input) {
        com.example.Assignments.Assignment6.service.Graph problem =
                new com.example.Assignments.Assignment6.service.Graph();
        return problem.getAdjacencyList(input);
    }
}
