package com.example.Assignments.Assignment5.service;

import com.example.Assignments.Utility;

public class Problem2 
{
	public static void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		
	}
	
	//The original partition function
	public static int partition(int[] A, int s, int e)
	{
		int pivot = A[s];
		int i = s + 1;
		int j = e;

		while (i<=j)
		{
			while (i < e & A[i] < pivot) 
				i = i + 1;
		
			while(j > s & A[j] >= pivot) 
				j = j - 1;
		
			if (i >= j) 
				break;
		
			swap(A, i, j);			
			
		}

			swap(A, s, j);
			return j;

	}
	
	
	
		
	
	/*public static int[] mpartition(int[] A, int s, int e)
	{
		//Permute the elements of A[s, . . ., e] and return two indices p and q, where s ≤ p ≤ q ≤ e, such that
		//• all elements of A[p, . . ., q] are equal,
		//• each element of A[s, . . ., p−1] is less than A[p], and
		//• each element of A[q+1, . . ., e] is greater than A[p].
		//Complete the function
		//Feel free to change the return type and parameters
		
		int pivot = A[s]; // randomly selected element (first element)
		int safe = s;
		int i = s + 1;
		int j = e;

		while (i<=j){
			while (i < e & A[i] < pivot){
				i = i + 1;
			}
			while(j > s & A[j] >= pivot){ 
				if(A[j] == pivot){
					if(i == safe + 1){
						i = i + 1;
					}
					swap(A, safe+1, j);
					safe = safe + 1;
				}
				j = j - 1;
			}
			if (i >= j){
				break;
			} 
			swap(A, i, j);			
		}
		while(safe >= s){
			swap(A, safe, j+1);
			safe--;
			j--;
		}
		return A;
	}*/

	public static int[] mpartition(int[] A, int s, int e) {
    // Choose the pivot (first element in the range)
    int pivot = A[s];
    // lt: boundary for elements < pivot
    // gt: boundary for elements > pivot
    // i: current element being examined
    int lt = s;
    int i = s;
    int gt = e;

    /*
     * Invariant at any point during the loop:
     * - A[s..lt-1] < pivot
     * - A[lt..i-1] == pivot
     * - A[i..gt] are unclassified
     * - A[gt+1..e] > pivot
     */
    while (i <= gt) {
        if (A[i] < pivot) {
            // Current element < pivot → swap with lt and expand < region
            swap(A, lt, i);
            lt++;
            i++;
        } else if (A[i] > pivot) {
            // Current element > pivot → swap with gt and shrink > region
            swap(A, i, gt);
            gt--;
            // Do NOT increment i here, because the element swapped from gt
            // still needs to be examined.
        } else {
            // Current element == pivot → just move forward
            i++;
        }
    }

    // After the loop:
    // A[s..lt-1] < pivot
    // A[lt..gt] == pivot
    // A[gt+1..e] > pivot
    // Return indices of the equal section
    return new int[]{lt, gt};
	}

	public int[] threeWayPartition(String A) {
		int[] B = Utility.parseIntArray(A);
		//Might want to add functionality later to make your own starting and ending indices
		//starting is pivot, so difenitely change the implementation later
		return mpartition(B, 0, B.length - 1);
	}
	
	public static void main(String[] args) 
	{
		
		// Test case 
		
		int[] testarray1 = {1, 2, 4, 1, -5, -2, 0, 6, 3, 1, 7, 8};
		int[] sortingQuiz = {10, 5, 550, 4, 10, 9, 330};
		
		mpartition(testarray1, 0, testarray1.length-1);
		mpartition(sortingQuiz, 0, sortingQuiz.length-1);

		int[] res = mpartition(testarray1, 0, testarray1.length-1);
		System.out.println("Equal section indices: " + res[0] + " to " + res[1]);
		System.out.print("Array after mpartition: ");
		for (int val : testarray1) {
    		System.out.print(val + " ");
		}
		System.out.println();
			
		//Output the array after the partition
		/*for(int i = 0; i < testarray1.length; i++)
		{
			System.out.print(testarray1[i] + " ");
		}
		for(int i = 0; i < sortingQuiz.length; i++)
		{
			System.out.print(sortingQuiz[i] + " ");
		}*/
		// -5 0 -2 1 1 1 2 6 3 4 7 8 expected
		
	}//main
}//Problem2
