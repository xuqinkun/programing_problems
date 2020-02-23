package pat;

import java.util.Scanner;

/**
 * 1002 A+B for Polynomials （25 分)
 * This time, you are supposed to find A+B where A and B are two polynomials.
 *
 * Input Specification:
 * Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial:
 * where K is the number of nonzero terms in the polynomial, N
 *
 * Output Specification:
 * For each test case you should output the sum of A and B in one line, with the same format as the input. Notice that there must be NO extra space at the end of each line. Please be accurate to 1 decimal place.
 *
 * Sample Input:
 * 2 1 2.4 0 3.2
 * 2 2 1.5 1 0.5
 * Sample Output:
 * 3 2 1.5 1 2.9 0 3.2
 */

public class PAT_1002_Polynomials {

    private static final int MAX_EXP = 1001;

    public static String getOutput(String exp1, String exp2) {
        double [] poly1 = formatInput(exp1);
        double [] poly2 = formatInput(exp2);
        StringBuilder builder = new StringBuilder();
        int total = 0;
        for (int i = MAX_EXP - 1; i >= 0; i--) {
            double coefficient = poly1[i] + poly2[i];
            if (Math.abs(coefficient) != 0) {
                builder.append(String.format("%d %.1f", i, coefficient));
                if (i != 0) {
                    builder.append(" ");
                }
                total ++;
            }
        }
        if (total == 0) {
            return "0";
        }
        String s = total + " " + builder.toString();
        return s.trim();
    }

    private static double[] formatInput(String exp) {
        String[] numbers = exp.split(" ");
        double [] poly = new double[MAX_EXP];
        for (int i = 1; i < numbers.length; i += 2) {
            int index = Integer.parseInt(numbers[i]);
            poly[index] = Double.parseDouble(numbers[i + 1]);
        }
        return poly;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        System.out.println(getOutput(first, second));
    }
}