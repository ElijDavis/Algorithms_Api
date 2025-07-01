package com.example.assignment4.service;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    // Static method to find max and 2nd max in an array using divide and conquer approach
	//static Max2ndMax result = new Max2ndMax();
    public static Max2ndMax dcfindmax2ndmax(int[] A, int i, int j) {
    // Complete this method to find max and 2nd max in an array A
    // At most 1.5n-2 comparisons
    // Algorithms that make more than 1.5n-2 comparisons will be scored out of 10 points
    // Complete the code from here
    // Feel free to change method type, parameters
    // The class of Max2ndMax is defined in a separate Java class in Assignment 4 folder

    // Base cases for recursion
    if (i == j) {
        Max2ndMax result = new Max2ndMax();
        result.setMax(A[i]);
        result.setMax2nd(Integer.MIN_VALUE); // Only one value, no second max
        return result;
    } else if (i + 1 == j) {
        // Base case: Two elements, compare and return
        Max2ndMax result = new Max2ndMax();
        result.setMax(Math.max(A[i], A[j]));
        result.setMax2nd(Math.min(A[i], A[j]));
        return result;
    } else {
        // Recursive case: split and conquer
        int mid = (i + j) / 2;
        Max2ndMax leftResult = dcfindmax2ndmax(A, i, mid);
        Max2ndMax rightResult = dcfindmax2ndmax(A, mid + 1, j);

        // Merge the results from left and right subarrays
        int globalMax = Math.max(leftResult.getMax(), rightResult.getMax());

        // Collect all four values from both sides
        List<Integer> candidates = new ArrayList<>();
        candidates.add(leftResult.getMax());
        candidates.add(leftResult.getMax2nd());
        candidates.add(rightResult.getMax());
        candidates.add(rightResult.getMax2nd());

        // Remove any instances of the global max so we can find the true 2nd max
        candidates.removeIf(val -> val == globalMax);

        // Get the highest remaining value as the 2nd max
        int global2ndMax = candidates.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);

        Max2ndMax result = new Max2ndMax();
        result.setMax(globalMax);
        result.setMax2nd(global2ndMax);
        return result;
    }
    }

	//Use to return a json object in the api
	public Max2ndMax solveJson(String input) {
    	String[] parts = input.split(",");
    	int[] arr = new int[parts.length];
    	for (int i = 0; i < parts.length; i++) {
        	arr[i] = Integer.parseInt(parts[i].trim());
    	}

    	return dcfindmax2ndmax(arr, 0, arr.length - 1);
	}


    public static void main(String[] args) {
		//TODO Auto-generated method stub
        int[] givenarray = {100, 2, 3, 4, 5, 6, 7, 67, 2, 32};
        //int[] givenarray = {10, 60, 3, 46, 26, 1098, 5, 9, 27, 193, 7}; 

        // Test the method
        Max2ndMax pair = dcfindmax2ndmax(givenarray, 0, givenarray.length - 1);
		// We have created a class of Max2ndMax
		// You can findn Max2ndMax.java in the assignment folder
        int max = pair.getMax();
        int max2nd = pair.getMax2nd();
        System.out.println("The max and 2nd max of the given array are " + max + " and " + max2nd + ".");
		// Your method should return 100 and 67
    }
}
