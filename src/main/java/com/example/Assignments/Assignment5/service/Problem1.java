package com.example.Assignments.Assignment5.service;

public class Problem1 {
	
	
	
	
	public static void intersection(int[] s1, int[] s2)
	{
		// complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
			int i = 0;
			int j = 0;
			int pre = Integer.MIN_VALUE; // Initialize pre with a very small value
		
			while (i < s1.length && j < s2.length) {
				if (s1[i] == s2[j] && pre != s1[i]) {
					print(s1[i] + " ");
					pre = s1[i];
					i++;
					j++;
				} else if (s1[i] < s2[j]) {
					i++;
				} else {
					j++;
				}
			}
		
	}
	
	public static void union(int[] s1, int[] s2)
	{
		// complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		int i = 0;
		int j = 0;
		int pre = Integer.MIN_VALUE; // Initialize pre with a very small value

		while (i < s1.length && j < s2.length) {
			if (s1[i] < s2[j]) {
				if (pre != s1[i]) {
					print(s1[i] + " ");
					pre = s1[i];
				}
				i++;
			} else if (s1[i] > s2[j]) {
				if (pre != s2[j]) {
					print(s2[j] + " ");
					pre = s2[j];
				}
				j++;
			} else { // Elements are equal
				if (pre != s1[i]) {
					print(s1[i] + " ");
					pre = s1[i];
				}
				i++;
				j++;
			}
		}

		// Print remaining elements of s1
		while (i < s1.length) {
			if (pre != s1[i]) {
				print(s1[i] + " ");
				pre = s1[i];
			}
			i++;
		}

		// Print remaining elements of s2
		while (j < s2.length) {
			if (pre != s2[j]) {
				print(s2[j] + " ");
				pre = s2[j];
			}
			j++;
		}
	}
	
	public static void print(int x){
		System.out.print(x);
	}
	public static void print(String x){
		System.out.print(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your intersection() method here
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		//should output 0, 1, 2, 3, 98
		System.out.println("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100
	}

}
