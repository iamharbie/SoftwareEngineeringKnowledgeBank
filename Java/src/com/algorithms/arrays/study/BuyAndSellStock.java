package com.algorithms.arrays.study;

import java.util.Arrays;
import java.util.List;

public class BuyAndSellStock {

    /**
     * Write a program that takes an array denoting the daily stock price,
     * and returns the maximum profit that could be made by buying
     * and then selling one share of that stock.
     *
     *
     * **/

    public static double computeMaxProfit(int[] prices) {
        // TODO - you fill in here.

        double maxProfit = 0.0, minPrice = Double.MAX_VALUE;
        for (double price:prices) {
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(minPrice,price);
        }
        return maxProfit;
    }

    public static double computeMaxProfitNaive(List<Double> prices) {
        // TODO - you fill in here.

        double max = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = i + 1; j <  prices.size(); j++) {
                if(prices.get(j) - prices.get(i) > max){
                    max = prices.get(j) - prices.get(i);
                }

            }
        }
        return max;
    }

    /**
     * Write a program that computes the maximum profit that can be made by buying and selling a share at most twice.
     * The second buy must be made on another date after the first sale.
     *
     * */

    public static double buyAndSellStockTwice(List<Double> prices) {
        // TODO - you fill in here.
        Double[] pricesArray =  prices.toArray(new Double[0]);

        double[] firstTrans = new double[pricesArray.length];
        double maxTotalProfit = 0.0;

        double minSoFar = Double.MAX_VALUE;

        for (int i = 0; i < pricesArray.length; i++) {
            minSoFar = Math.min(minSoFar,pricesArray[i]);
            maxTotalProfit = Math.max(maxTotalProfit,pricesArray[i] - minSoFar);
            firstTrans[i] = maxTotalProfit;
        }

        double maxSoFar = Double.MIN_VALUE;
        for (int i = pricesArray.length - 1; i > 0; i--) {
            maxSoFar = Math.max(maxSoFar,pricesArray[i]);
            maxTotalProfit = Math.max(maxTotalProfit,maxSoFar - pricesArray[i] + firstTrans[i -1]);
        }



        System.out.println(Arrays.toString(firstTrans));
        return maxTotalProfit;
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 2, 90, 10, 110};
        System.out.println(computeMaxProfit(arr));

    }
}
