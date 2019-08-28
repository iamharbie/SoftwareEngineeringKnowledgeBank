package com.algorithms.sorting.study;

import java.util.Arrays;

public class HeapSort {

    private static int getParentIndex(int i){
        return (i-1) /2;
    }

    private static int getLeftChildIndex(int parent){
        return 2 * parent + 1;
    }

    private static int getRightChildIndex(int parent){
        return 2 * parent + 2;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void siftDown(int[] A, int index, int size){
        int maxIndex = index;

        int leftChildIndex = getLeftChildIndex(maxIndex);
        int rightChildIndex = getRightChildIndex(maxIndex);

        if(leftChildIndex < size && A[maxIndex] < A[leftChildIndex] )
            maxIndex = leftChildIndex;

        if(rightChildIndex < size && A[maxIndex] < A[rightChildIndex])
            maxIndex = rightChildIndex;

        if(maxIndex != index){
            swap(A,index, maxIndex);
            siftDown(A,maxIndex,size);
        }
    }


    private static void sort(int[] A){
        int n = A.length;
        //Sift down the remaining half of the tree since half of the tree is a t
        // the bottom and they satisfy the max heap property
        for (int index = n / 2; index >= 0 ; index--) {
            siftDown(A,index,n);
        }

        int size = n;
        //Swap the max with the last item in the array and make that part sorted
        while (size > 0){
            swap(A,0,size - 1);
            size--;
            siftDown(A,0,size);
        }

    }

    public static void main(String[] args){
        int[] A  = new int[] { 1,5,0,2,-1,4,-7,2,13};

        sort(A);
        System.out.println(Arrays.toString(A));
    }




}
