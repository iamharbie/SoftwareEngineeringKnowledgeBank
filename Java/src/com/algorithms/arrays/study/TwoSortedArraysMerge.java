package com.algorithms.arrays.study;

import java.util.Arrays;
import java.util.List;

public class TwoSortedArraysMerge {


    /**
     * Write a program which merges two sorted arrays of integers, A and B.
     * Specifically, the final result should be a sorted array of length m + n,
     * where n and m are the lengths of A and B, respectively.
     * Use 0(1) additional storage—assume the result is stored in A,
     * which has sufficient space. These arrays are C-style arrays, i.e., contiguous preallocated blocks of memory.
     *
     * **/

    private static void mergeTwoSortedArrays(int[] A, int m,
                                             int[] B, int n) {
        // TODO - you fill in here.

        int finalIndex = m + n - 1;
        int firstReadIdx = m -1, secondReadIdx = n -1;

//        while(firstReadIdx >= 0 && secondReadIdx >= 0){
//            if(A[firstReadIdx] >= B[secondReadIdx]){
//                A[finalIndex]= A[firstReadIdx--];
//            }else{
//                A[finalIndex] = B[secondReadIdx--];
//            }
//            finalIndex--;
//        }
//
//        while(firstReadIdx >=0){
//            A[finalIndex--]=A[firstReadIdx--];
//        }
//        while(secondReadIdx >= 0){
//            A[finalIndex--]=B[secondReadIdx--];
//        }

        while(secondReadIdx >= 0){
            if( firstReadIdx >= 0 && A[firstReadIdx] >= B[secondReadIdx]){
                A[finalIndex] = A[firstReadIdx--];
            }else{
                A[finalIndex] = B[secondReadIdx--];
            }

            finalIndex--;
        }

    }



    public static void main (String[] args)
    {
        int a[] = {10, 12, 13, 14, 18, 0, 0, 0, 0, 0};
        int m = 5;
        int b[] = {16, 17, 19, 20, 22};
        int n = 5;
        mergeTwoSortedArrays(a, m, b, n);
        System.out.println(Arrays.toString(a));

    }
}
