package leetcode.medium.double_pointers;

public class Exc_633_JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.ceil(Math.sqrt(c));
        while (l <= r) {
            long sum = (long) l *l + (long) r *r;
            if (sum == c)
                return true;
            else if (sum > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exc_633_JudgeSquareSum jss = new Exc_633_JudgeSquareSum();
//        System.out.println(jss.judgeSquareSum(5));
//        System.out.println(jss.judgeSquareSum(2));
//        System.out.println(jss.judgeSquareSum(3));
//        System.out.println(jss.judgeSquareSum(4));
//        System.out.println(jss.judgeSquareSum(10));
        System.out.println(jss.judgeSquareSum(2147483600));
    }
}
