package com.example.Assignments.ExtraCredit.service;

import java.util.Arrays;

public class ThreewayMergeSort {
    public static void main(String[] args) {
        int[] A = new int[] {3, 9, 10, 1, 8, 7, 5, 2};
        MergeSort3way(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        // Expected output: [1, 2, 3, 5, 7, 8, 9, 10]
    }

    public static void MergeSort3way(int[] A, int start, int end) {
        if (start < end) {
            int mid1 = start + (end - start) / 3;
            int mid2 = start + 2 * (end - start) / 3;

            MergeSort3way(A, start, mid1);
            MergeSort3way(A, mid1 + 1, mid2);
            MergeSort3way(A, mid2 + 1, end);

            merge(A, start, mid1, mid2, end);
        }
    }

    public static void merge(int[] A, int start, int mid1, int mid2, int end) {
        int[] L = Arrays.copyOfRange(A, start, mid1 + 1);
        int[] M = Arrays.copyOfRange(A, mid1 + 1, mid2 + 1);
        int[] R = Arrays.copyOfRange(A, mid2 + 1, end + 1);

        int i = 0, j = 0, k = 0, l = start;

        while (i < L.length && j < M.length && k < R.length) {
            if (L[i] <= M[j] && L[i] <= R[k]) {
                A[l++] = L[i++];
            } else if (M[j] <= L[i] && M[j] <= R[k]) {
                A[l++] = M[j++];
            } else {
                A[l++] = R[k++];
            }
        }

        while (i < L.length && j < M.length) {
            if (L[i] <= M[j]) {
                A[l++] = L[i++];
            } else {
                A[l++] = M[j++];
            }
        }

        while (j < M.length && k < R.length) {
            if (M[j] <= R[k]) {
                A[l++] = M[j++];
            } else {
                A[l++] = R[k++];
            }
        }

        while (i < L.length) {
            A[l++] = L[i++];
        }

        while (k < R.length) {
            A[l++] = R[k++];
        }
    }
}

