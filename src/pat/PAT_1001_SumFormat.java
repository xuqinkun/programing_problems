package pat;

import java.util.Scanner;

public class PAT_1001_SumFormat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.split(" ");
        int first = Integer.parseInt(nums[0]);
        int second = Integer.parseInt(nums[1]);
        int result = first + second;
        String ret = getString(result);
        System.out.println(ret);
    }

    private static String getString(int result) {
        if (result == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (result < 0) {
            isNegative = true;
            result = -result;
        }
        int tmp = result;
        String ret = "";
        int i = 1;
        while (tmp > 0) {
            ret = tmp % 10 + ret;
            tmp /= 10;
            if (tmp != 0 && i ++ % 3 == 0) {
                ret = "," + ret;
            }
        }
        if (isNegative) {
            ret = "-" + ret;
        }
        return ret;
    }
}