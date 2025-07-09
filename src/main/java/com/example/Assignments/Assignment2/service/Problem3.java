package com.example.Assignments.Assignment2.service;

//Elijah Davis
//Cmpt 435L 111
//feb 14 2024
public class Problem3 {

	public static double squareroot(int x)
	{
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected
		// Algorithms slower than O(logn) will be graded out of 10 points
		// feel free to change the return type or parameters

		double left;
		double right;
		double a = .0002;
		
		if(x < 1){
			left = x;
			right = 1;
		}else{
			left = 1;
			right = x;
		}

		while(Math.abs((right - left)) > a){
			double mid = (left + right) / 2;
			double squared =  mid*mid;
			if(squared > x){
				right = mid;
			}else{
				left = mid;
			}
		}
		return Math.floor(left);
	}
	
	public double sqrt(String x){
		// Overloaded method to call the recursive squareroot with initial parameters
		double inputDouble = Double.parseDouble(x);
		return squareroot((int) inputDouble);
	}
	
	public static void main(String[] args) {
		// test your squareroot() method here
		
		int x1 = 9;
		int x2 = 5;
		int x3 = 17;
		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		// 3 expected
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		// 2 expected
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		// 4 expected
		
		
	}

}
