package com.example.Assignments.Assignment9.service;

public class ContiguousSumDP {
	
	public static int MaximumSumContSubsequence(int[] A) {
		
		
		int[] Local_maximum =  new int[A.length];
		int greatest = 0;
		Local_maximum[0] = A[0];
 
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Maximum Sum Contiguous Subsequence Algorithm
		// Return the maximum sum of contiguous subsequence in A[]
		// Hint: Follow the pseudocode of maximum sum of contiguous subsequence in Assignment 9
		for(int i = 1; i < A.length; i++){
			if(Local_maximum[i-1] + A[i] > A[i]){
				Local_maximum[i] = Local_maximum[i-1] + A[i];
			}else if(Local_maximum[i-1] + A[i] < A[i]){
				Local_maximum[i] = A[i];
			}
		}
		
		for(int i = 0; i < Local_maximum.length; i++){
			greatest = (greatest > Local_maximum[i]) ? greatest : Local_maximum[i];
		}
		return greatest;

	}

	public static void main(String[] args) {
		
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		
		System.out.println("The maximum sum of contiguous subsequence in A[] = " +  MaximumSumContSubsequence(A) );
		//Given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	}

}
