/*package com.example.assignment4.controller;

import com.example.assignment4.service.Max2ndMax;
import com.example.assignment4.service.Problem1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem1")
public class Problem1Controller {

    private final Problem1 problem1 = new Problem1();

    // Uncomment this method if you want to use the divide and conquer approach directly in the terminal
    /*@PostMapping("/run")
    public Max2ndMax runProblem(@RequestBody int[] input) {
        return Problem1.dcfindmax2ndmax(input, 0, input.length - 1);
    }*/

    /*@GetMapping("/run-json")
    public Max2ndMax runJson(@RequestParam String input) {
        return problem1.solveJson(input);
    }*/

    /*@PostMapping("/run-json")
    public Max2ndMax runJson(@RequestBody String input) {
        return problem1.solveJson(input);
    }


}*/

package com.example.assignment4.controller;

import com.example.assignment4.service.Max2ndMax;
import com.example.assignment4.service.Problem1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problem1")
public class Problem1Controller {

    private final Problem1 problem1 = new Problem1();

    // POST endpoint that accepts a JSON object: { "input": "10,60,3,..." }
    @PostMapping("/run-json")
    public Max2ndMax runJson(@RequestBody InputWrapper inputWrapper) {
        return problem1.solveJson(inputWrapper.getInput());
    }

    // Wrapper class to map JSON input
    public static class InputWrapper {
        private String input;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }
    }
}
