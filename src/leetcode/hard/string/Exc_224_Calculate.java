package leetcode.hard.string;

import java.util.Stack;

public class Exc_224_Calculate {

    public int calculate(String s) {
        int ret = 0, i = 0, n = s.length();
        int sign = 1;
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '(') {
                i++;
                ops.push(sign);
            } else if (c == ')') {
                i++;
                ops.pop();
            }
            else if (c == '+') {
                i++;
                sign = ops.peek();
            } else if (c == '-') {
                i++;
                sign = -ops.peek();
            } else {
                int num = 0;
                c = s.charAt(i);
                while (i < n && c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    i++;
                    if (i < n)
                        c = s.charAt(i);
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Exc_224_Calculate calc = new Exc_224_Calculate();
//        System.out.println(calc.calculate("1 + 1"));
        System.out.println(calc.calculate("29-(1+(4+5+2)-3)"));
        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
