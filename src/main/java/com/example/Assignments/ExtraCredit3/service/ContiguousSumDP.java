package com.example.Assignments.ExtraCredit3.service;

//Elijah Davis
//5/05/2024
//CMPT 435

public class ContiguousSumDP {

    public static int MaximumSumContSubsequence(int[] A) {
        int n = A.length;
        
        if (n == 0)
            return 0;

        int[] localMax = new int[n];
        localMax[0] = A[0];
        int globalMax = A[0];

        for (int i = 1; i < n; i++) {
            localMax[i] = Math.max(A[i], localMax[i - 1] + A[i]);
            globalMax = Math.max(globalMax, localMax[i]);
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("The maximum sum of contiguous subsequence in A[] = " + MaximumSumContSubsequence(A));
        // Given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    }
}
