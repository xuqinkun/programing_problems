package leetcode.easy.math;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_202_HappyNum
 * Author:   Xu Qinkun
 * Date:     2020/4/30 10:29
 * Description:
 */

public class Exc_202_HappyNum {

    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int x) {
        int sum = 0, tmp;
        while (x != 0) {
            tmp = x % 10;
            sum += tmp * tmp;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Exc_202_HappyNum hn = new Exc_202_HappyNum();
        System.out.println(hn.isHappy(1));
    }
}
