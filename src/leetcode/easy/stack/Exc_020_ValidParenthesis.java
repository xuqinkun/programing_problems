package leetcode.easy.stack;

import java.util.Stack;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_020_ValidParenthesis
 * Author:   Xu Qinkun
 * Date:     2020/3/19 10:38
 * Description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */

public class Exc_020_ValidParenthesis {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (char c : chars) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else return false;
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else return false;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Exc_020_ValidParenthesis vp = new Exc_020_ValidParenthesis();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("()("));
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("([)]"));
    }
}
