package com.algorithms.strings.study;

public class BaseConversion {

    /**
     * Implement a function that converts a spreadsheet column id to the corresponding integer,
     * with "A" corresponding to 1.
     * For example, you should return 4 for "D", 27 for "AA", 702 for "ZZ", etc.
     *
     * **/

    private static int ssDecodeColID(final String col) {

        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            char ch = col.charAt(i);
            result *= 26;
            result += ch - 'A' + 1;
        }
        return result;
    }

    /**
     * Implement a function that converts an integer to the spreadsheet column id.
     * For example, you should return "D" for 4, "AA" for 27, and "ZZ" for 702.
     * **/

    private static String  ssEncodeColID(int encodedColumn){
        if(encodedColumn == 0) return "";

        String end = ssEncodeColID((encodedColumn - 1) / 26);
        return end + (char)((encodedColumn - 1) % 26 + 'A');

    }
    public static void main(String[] args) {

        System.out.println(ssDecodeColID("Z"));
        System.out.println(ssEncodeColID(26));

    }


}
