package com.example.Assignments.Assignment2.service;

import static com.example.Assignments.Utility.parseDoubleArray;

//import java.util.Arrays;
//Elijah Davis
//Cmpt 435L 111
//feb 14 2024

public class Problem2 {
	static int temp = 0;
	static int amount = 0;
	//static boolean low = false;
	//static boolean high = false;

	public static int count(double[] A, double x, int start, int end)
	{
		// given a sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// feel free to change the return type or parameters
		
		//Arrays.sort(A);
		//System.out.println("Start = " + start + " End = " + end + " Mid = " + mid + " Amount = " + amount + " Temp = " + temp + " | " + 1)

		if (start > end) {
			return 0;
		  }
		  // Find the middle index
		  int mid = (start + start) / 2;
		  // If the middle element is equal to x, count it and recur on both sides
		  if (A[mid] == x) {
			return 1 + count(A, x, start, mid - 1) + count(A, x, mid + 1, end);
		  }
		  // If the middle element is smaller than x, recur on the right side
		  else if (A[mid] < x) {
			return count(A, x, mid + 1, end);
		  }
		  // If the middle element is larger than x, recur on the left side
		  else {
			return count(A, x, start, mid - 1);
		  }

		//return amount;
		
	}
	
	public int count_(String input) {
		// Overloaded method to call the recursive count with initial parameters
		//input is a comma-separated string of doubles, and the last parameter is the value to count
		double[] A = parseDoubleArray(input);
		double B = A[A.length - 1];
		return count(A, B, 0, A.length - 1);
	}
	
	public static void main(String[] args) {
		// test your count() method here
		
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1, 0, testarray.length) + " times");
		// 4 expected
		System.out.println(t2+" appears "+ count(testarray, t2, 0, testarray.length) + " times");
		// 2 expected 
		System.out.println(t3+" appears "+ count(testarray, t3, 0, testarray.length) + " times");
		// 1 expected
		
		
	}

}
