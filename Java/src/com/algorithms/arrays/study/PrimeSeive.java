package com.algorithms.arrays.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSeive {

    /**
     * Write a program that takes an integer argument and returns all the primes between 1 and that integer.
     * For example, if theinput is 18,you should return (2,3,5,7,11,13,17).
     * **/

    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if(isPrime[i]){
                primes.add(i);
                for (int j = i+i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {

        System.out.println(generatePrimes(15));

    }
}
