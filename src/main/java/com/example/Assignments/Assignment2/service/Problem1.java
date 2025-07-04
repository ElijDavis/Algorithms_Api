package com.example.Assignments.Assignment2.service;

////Elijah Davis
//Cmpt 435L 111
//feb 14 2024
import java.util.Arrays;
import java.util.List;

public class Problem1 {

	public static boolean findi(int[] A, int start, int end)
	{
		// given an array A of n integers 
		// return true if there exists an index i such that A[i] = i 
		// false otherwise
		// complete the method findi() here
		// O(log n) time expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// feel free to change the return type or parameters
		
		Arrays.sort(A);
		boolean found = false;
		int mid = (start + end) / 2;
		if(A[mid] == mid){
			found = true;
			//System.out.println(found);
		}else if(A[mid] < mid){
			start = mid + 1;
			if(findi(A, start, end) == true){
				found = true;
			}else{
				findi(A, start, end);
			}
			//System.out.println(found);
		}else if(A[mid] > mid){
			end = mid - 1;
			if(findi(A, start, end) == true){
				found = true;
			}else{
				findi(A, start, end);
			}
			//System.out.println(found);
		}else{
			//System.out.println("worked 4");
			found = false;
		}

		return found;
	}
	

	
	public static void main(String[] args) {
		// test your maximum() method here
		
		int[] testarray = {-4, 0, 2, 5, 10, 27, 39, 52};

		System.out.println("There exists an index i in the input array that A[i] = i "+ findi(testarray,0,testarray.length));
		// true expected
	
		
	}

}