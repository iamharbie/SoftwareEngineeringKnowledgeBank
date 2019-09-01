package com.algorithms.arrays.study;

import java.util.Arrays;

public class MinJumps {

    /**
     * The variable maxReach stores at all time the maximal reachable position in the array.
     * jump stores the amount of jumps necessary to reach that position.
     * step stores the amount of steps we can still take (and is initialized with the amount of steps at the first array position)
     *
     *
     * During the iteration, the above values are updated as follows:
     *
     * First we test whether we have reached the end of the array,
     * in which case we just need to return the jump variable.
     *
     * Next we update the maximal reachable position.
     * This is equal to the maximum of maxReach and i+A[i] (the number of steps we can take from the current position).
     *
     * We used up a step to get to the current index, so steps has to be decreased.
     *
     * If no more steps are remaining
     * (i.e. steps=0, then we must have used a jump.
     * Therefore increase jump. Since we know that it is possible somehow to reach maxReach,
     * we initialize the steps to the amount of steps to reach maxReach from position i.
     *
     * **/

    private static int minJumps(int[] A) {
        if (A.length <= 1) return 0;


        int maxReach = A[0];
        int step = A[0];
        int jump = 1;
        for (int i = 1; i < A.length; i++) {
            if (i == A.length - 1)
                return jump;
            if (i + A[i] > maxReach)
                maxReach = i + A[i];
            step--;
            if (step == 0) {
                jump++;
                step = maxReach - i;
            }
        }
        return jump;
    }

    public static void main(String args[])
    {
        int arr[] = {2,3,1,1,4};
        int n = arr.length;
        System.out.print(minJumps(arr));
    }


}
