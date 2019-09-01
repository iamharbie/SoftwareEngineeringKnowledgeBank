package com.algorithms.arrays.study;

import java.util.Arrays;

public class DeleteDuplicates {




    public static void main(String args[])
    {
        int A[] = {1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,5,6};
        deleteDuplicates(A);
        System.out.println(Arrays.toString(A));


        int B[] = {1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,5,6};
        removeKey(B,2);
        System.out.println(Arrays.toString(B));

        int C[] = {1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,4,5,6};
        updateKey(C,3);
        System.out.println(Arrays.toString(C));
    }

    /**
     * Write a program which takes as input a sorted array and updates it so that all duplicates have been removed
     * and the remaining elements have been shifted left to fill the emptied indices.
     * Return the number of valid elements.
     * Many languages have library functions for performing this operation—you cannot use these functions.
     * **/
    private static int deleteDuplicates(int[] A) {

        int writeIndex = 1;
        for (int i = 1; i < A.length ; i++) {
            if(A[writeIndex -1] != A[i] ){
                A[writeIndex] = A[i];
                ++writeIndex;
            }


        }

        for (int i = writeIndex; i < A.length; i++) {
            A[i] = 0;
        }
        return writeIndex;
    }

    /**
     * Variant: Implement a function which takes as input an array and
     * a key and updates the array so that all occurrences of the input key have been removed
     * and the remaining elements have been shifted left to fill the emptied indices.
     * Return the number of remaining elements.
     * There are no requirements as to the values stored beyond the last valid element.
     * **/

    private static int removeKey(int[] A, int key){
        int writeIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] != key){
                A[writeIndex] = A[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    /**
     * Variant: Write a program which takes as input a sorted array A of integers and a positive integer m,
     * and updates A so that if x appears m times in A it appears exactly min(2,m) times in A.
     * The update to A should be performed in one pass, and no additional storage may be allocated.
     * **/
    private static void updateKey(int[] A, int m){
        int maxCount = Math.min(2,m);
        int currElement = A[0];
        int currElementCount = 1;
        int writeIndex = 1;

        for (int i = 1; i < A.length; i++) {
           if (A[i] == currElement){
               ++currElementCount;
           } else {
               currElement = A[i];
               currElementCount = 1;
           }

           if(currElementCount <= maxCount){
               A[writeIndex] = A[i];
               writeIndex++;
           }

        }
    }

}
