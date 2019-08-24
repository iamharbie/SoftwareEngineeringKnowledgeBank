package com.algorithms.sorting.review;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] A, int left, int right){

        if(left >= right) return;    //[3,2,1]

        int m = left + ( right - left) / 2;


        mergeSort(A,left,m);
        mergeSort(A,m+1,right);

        merge(A,left,m,right);
    }

    private static void merge(int[] A, int left, int mid, int right) {
        //[2 ,3, 4, 1, 5] -- temp
        // left        right
        //       mid
        //

        int[] temp = new int[A.length];
        System.arraycopy(A, left, temp, left, right + 1 - left);

        int i = left, j=mid+1;

//        while (i<=mid && j<=right){
//            if (temp[i] > temp[j] ){
//                A[k] = temp[j];
//                k++;
//                j++;
//            }else{
//                //A[i] <= A[j]
//                A[k] = temp[i];
//                k++;
//                i++;
//            }
//        }
//
//        while (i <= mid){
//            A[k] = temp[i];
//            k++;
//            i++;
//        }
//
//        while (j<=right){
//            A[k] = temp[j];
//            k++;
//            j++;
//        }

        for (int k = left; k <= right; k++) {
            if(i>mid) A[k] = temp[j++];
            else if (j > right) A[k] =  temp[i++];
            else if(temp[i] <= temp[j]) A[k] = temp[i++];
            else A[k] = temp[j++];
        }


    }


    public static void main(String[] args){
        int[] A  = new int[] { 1,5,0,2,-1,4,-7,2,13};

        mergeSort(A,0,A.length-1);
        System.out.println(Arrays.toString(A));

    }
}
