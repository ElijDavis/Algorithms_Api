package com.example.Assignments.Assignment3.service;

import static com.example.Assignments.Utility.parseIntArray;

public class Problem2 {
	private static int power = 0; // Declare as int

    public static int Countdigit(int num) {

		// complete the method from here
		// input: an integer num
		// output: the number of digits in num
		// a recursive function that does not contain a loop
		// feel free to change the function return type and the parameters

        int low = (int) Math.pow(10, power);
        int high = (int) Math.pow(10, (power + 1));

        if ((low < num) && (num < high)) {
            return power + 1;
        } else if (num < 10) {
            return 1;
        } else {
            power++;
            return Countdigit(num);
        }
    }

	public int Count_(String numStr) {
		int num = parseIntArray(numStr)[0]; // Assuming numStr is a single integer in string format
		return Countdigit(num);
	}

	public static void main(String[] args) {
		// test your Countdigit() method here
		System.out.println(Countdigit(1234));
		// 4 expected
		System.out.println(Countdigit(491526));
		// 6 expected
		
	}
	
}
