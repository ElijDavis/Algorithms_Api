package com.example.Assignments.Assignment3.service;

import com.example.Assignments.Utility;

public class Problem1 {

	static int greatest = 0;
	static int index = 0;

	public static int largest(int[] A)
	{
		// complete the method from here
		// input: an array A[]
		// output: the largest element in A[]
		// a recursive function that does not contain a loop
		// feel free to change the function return type and the parameters	

		if(A.length == 1){
			return A[0];
		}
		greatest = (A[index] > A[index + 1]) ? A[index] : A[index + 1];
		if(index < A.length - 2){
			index++;
			largest(A);
		}
		return (A[index] > greatest) ? A[index] : greatest;

	}

	public int biggie(String arr){
		int[] A = Utility.parseIntArray(arr);
		return largest(A);
	}

	public static void main(String[] args) {
		// test your largest() method here
		int[] testarray = {12,25,36,85,28};
		System.out.println(largest(testarray));
		// 85 expected

		
	}
	
}
