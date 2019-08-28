package com.algorithms.sorting.study;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort3Way {
    private static Random random = new Random();


    private static void quickSort3Way(int[] A, int left, int right) {
        if(left >= right) return;


        int k =random.nextInt(right - left + 1) + left;
        int t = A[left];
        A[left] = A[k];
        A[k] = t;


        int[] partitionIndices = partition(A, left,right);

        quickSort3Way(A,left,partitionIndices[0] -1);
        quickSort3Way(A,partitionIndices[1] + 1,right);


    }

    private static int[] partition(int[] A, int left, int right) {
        int pivot = A[left];

        int i = left, j = left, k= right;

        while (j<=k){
            if(A[j] < pivot){
                swap(A,i,j);
                i++;
                j++;
            }else if(A[j] == pivot) j++;
            else{
                // A[j]> pivot
                swap(A,j,k);
                k--;
            }
        }

        return new int[]{i,j};

    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void   main(String[] args){
        int[] A  = new int[] { 1,5,0,2,-1,4,-7,2,13};
//        int[] A  = new int[] { 2 ,3 ,9 ,2 ,9};

        quickSort3Way(A,0,A.length-1);
        System.out.println(Arrays.toString(A));



    }


}
