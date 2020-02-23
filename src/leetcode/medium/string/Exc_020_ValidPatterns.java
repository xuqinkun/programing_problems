package leetcode.medium.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */

public class Exc_020_ValidPatterns {

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char next = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(next);
            }
            else {
                Character top = stack.peek();
                if (top == '(' && next == ')'
                        || top == '{' && next == '}'
                        || top == '[' && next == ']') {
                    stack.pop();
                }
                else {
                    stack.push(next);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(""));
        System.out.println(isValid("{}"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("({[]})"));
    }
}
