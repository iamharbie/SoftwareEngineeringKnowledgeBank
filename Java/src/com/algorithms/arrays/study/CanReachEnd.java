package com.algorithms.arrays.study;


import java.util.Arrays;

public class CanReachEnd {


    enum Index {
        GOOD, BAD, UNKNOWN
    }


    private static boolean canReachEnd(int[] A) {
        //Brute force

        //return canReachEndFromPosition(0,A);

        //Greedy
       /** Index[] memo = new Index[A.length];
        Arrays.fill(memo,Index.UNKNOWN);
        memo[A.length - 1] = Index.GOOD;

        return canReachEndFromPosition(0,A,memo);

        **/
        return canReachEndGreedyRTL(A);
    }

    /**
     * Once we have our code in the bottom-up state, we can make one final, important observation.
     * From a given position, when we try to see if we can jump to a GOOD position,
     * we only ever use one - the first one (see the break statement).
     * In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable,
     * we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.
     *
     *
     * Iterating right-to-left,
     * for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex).
     * If we can reach a GOOD index, then our position is itself GOOD.
     * Also, this new GOOD position will be the new leftmost GOOD index.
     * Iteration continues until the beginning of the array.
     * If first position is a GOOD index then we can reach the last index from the first position.
     *
     * To illustrate this scenario, we will use the diagram below,
     * for input array nums = [9, 4, 2, 1, 0, 2, 0]. We write G for GOOD, B for BAD and U for UNKNOWN.
     * Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD.
     * Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6.
     * It does not matter that nums[0] is big enough to jump all the way to the last index. All we need is one way.
     * **/
    private static boolean canReachEndGreedyRTL(int[] A) {
        int lastGoodPosition = A.length - 1;
        for (int currPosition = A.length - 2; currPosition >=0 ; currPosition--) {
            if(currPosition + A[currPosition] >= lastGoodPosition) {
                lastGoodPosition = currPosition;
            }
        }

        return lastGoodPosition == 0;

    }

    private static boolean canReachEndGreedyLTR(int[] A){
        int furthestReachSoFar = 0, lastIndex = A.length - 1;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
            if(i + A[i] > furthestReachSoFar){
                furthestReachSoFar = Math.max(furthestReachSoFar , i + A[i]);
            }

        }

        return furthestReachSoFar >= lastIndex;
    }

    /**
    * DP Top Down approach, if a step leads us to a bad move, then the result of that move would never change -- O(n^2)
    *
    * */

    private static boolean canReachEndFromPosition(int position, int[] nums, Index[] memo) {
        if(memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int farthestJumpFromHere = position + nums[position];
        for (int nextPosition = farthestJumpFromHere; nextPosition > position; nextPosition--) {
            if(canReachEndFromPosition(nextPosition,nums,memo)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;

        return false;




    }

    //Brute force --  try all approach from the beginning till you get to the end
    //A little optimization is to start from the max position you can jump to -- same time complexity --- O(2^n)
    private static boolean canReachEndFromPosition(int position, int[] nums) {
        if(position == nums.length - 1) return true;


        int farthestJumpFromHere = position + nums[position];
        for (int nextPosition = farthestJumpFromHere; nextPosition > position; nextPosition--) {
            if(canReachEndFromPosition(nextPosition,nums)) return true;
        }

        return false;
    }


    public static void main(String args[])
    {
        int arr[] = {2,3,1,1,4};
        System.out.println(canReachEnd(arr));
        System.out.print(canReachEndGreedyLTR(arr));
    }


}
