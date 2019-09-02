package com.algorithms.strings.study;


public class IntStringConverter {


    private static int stringToInt(String input) {

        int result = 0;

        for (int i = input.charAt(0) == '-' ? 1 : 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';

            result = result * 10 + digit;
        }

        return input.charAt(0) == '-' ? -result : result;
    }

    private static String intToString(int input){
        boolean isNegative = input < 0;

        StringBuilder result = new StringBuilder();

        do {
            char lastDigit = (char) (Math.abs(input) % 10 + '0') ;
            result.append(lastDigit);
            input = input / 10;
        } while (input != 0);


        if (isNegative) result.append('-');
        return result.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(stringToInt("-12322"));
        System.out.println(intToString(1));

    }


}
