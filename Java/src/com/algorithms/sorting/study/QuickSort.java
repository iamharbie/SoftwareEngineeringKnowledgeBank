package com.algorithms.sorting.study;

import java.util.Arrays;

public class QuickSort {

    private static void quicksort(int[] A, int left, int right){
        if(left >= right) return;

        int partitionIndex = partition(A, left, right);

        quicksort(A,left, partitionIndex - 1);
        quicksort(A,partitionIndex + 1 ,right);
    }

    private static int partition(int[] A, int left, int right) {
        //Always use the first item in the array as pivot
        int pivot = A[left];

        int i = left; //Keeps the index of last seen item <= pivot

        //Loops keeps the invariant which maintains 3 partition in the array
        //[{pivot}, {<=pivot},{>pivot}]
        for (int j = i + 1; j <= right; j++) {
            if(A[j] <= pivot){
                i++;
                swap(A,i,j);

            }
        }

        //Swap pivot with last item i point to
        swap(A,left,i);
        //[ {<=pivot},{>pivot}]
        return i;



    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void   main(String[] args){
        int[] A  = new int[] { 1,5,0,2,-1,4,-7,2,13};

        quicksort(A,0,A.length-1);
        System.out.println(Arrays.toString(A));
    }

}
