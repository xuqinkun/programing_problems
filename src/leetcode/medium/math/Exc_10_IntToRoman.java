package leetcode.medium.math;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Exc_10_IntToRoman {

    /**
     *
     * @param num num <= 3999
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) {
            builder.append("M");
        }
        num %= 1000;
        int hundreds = num / 100;
        if (hundreds == 9) {
            builder.append("CM");
        } else if (hundreds > 5 && hundreds < 9) {
            builder.append("D");
            for (int i = 5; i < hundreds; i++) {
                builder.append("C");
            }
        } else if (hundreds == 5) {
            builder.append("D");
        } else if (hundreds == 4) {
            builder.append("CD");
        } else {
            for (int i = 0; i < hundreds; i++) {
                builder.append("C");
            }
        }
        return builder.toString();
    }

//    public String numToRoman(int n) {
//        StringBuilder builder = new StringBuilder();
//
//    }
}