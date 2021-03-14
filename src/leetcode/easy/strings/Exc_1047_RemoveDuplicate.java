package leetcode.easy.strings;

import java.util.Stack;

public class Exc_1047_RemoveDuplicate {

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop());
        }
        return ret.toString();
    }

    public String removeDuplicates2(String str) {
        StringBuilder stack = new StringBuilder();
        int top = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (top != 0 && stack.charAt(top-1) == c) {
                top--;
            } else {
                stack.insert(top, c);
                top++;
            }
        }

        return stack.substring(0, top);
    }

    public static void main(String[] args) {
        Exc_1047_RemoveDuplicate rd = new Exc_1047_RemoveDuplicate();
        System.out.println(rd.removeDuplicates2("abbaca"));
        System.out.println(rd.removeDuplicates2("abbacca"));
    }
}
