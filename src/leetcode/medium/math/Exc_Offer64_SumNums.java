package leetcode.medium.math;

public class Exc_Offer64_SumNums {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Exc_Offer64_SumNums sn = new Exc_Offer64_SumNums();
        System.out.println(sn.sumNums(3));
    }
}
