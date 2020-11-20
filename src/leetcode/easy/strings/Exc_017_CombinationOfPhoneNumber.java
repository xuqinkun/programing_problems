package leetcode.easy.strings;

import java.util.ArrayList;
import java.util.List;

public class Exc_017_CombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits != null && digits.trim().length() > 0)
            dfs(digits, 0, ret, new StringBuilder());
        return ret;
    }

    private char numToLetter(int n, int i) {
        if (n >= 2 && n <= 7) {
            return (char) ('a' + (n - 2) * 3 + i);
        } else {
            return (char) ('a' + (n - 2) * 3 + 1 + i);
        }
    }

    private void dfs(String digits, int start, List<String> ret, StringBuilder temp) {
        if (temp.length() == digits.length()) {
            ret.add(temp.toString());
            return;
        }
        int n = digits.charAt(start) - '0';
        int len = 3;
        if (n == 7 || n == 9) {
            len = 4;
        }
        for (int i = 0; i < len; i++) {
            temp.append(numToLetter(n, i));
            dfs(digits, start + 1, ret, temp);
            temp.replace(temp.length() - 1, temp.length(), "");
        }
    }

    public static void main(String[] args) {
        Exc_017_CombinationOfPhoneNumber cp = new Exc_017_CombinationOfPhoneNumber();
        System.out.println(cp.letterCombinations(""));
    }
}
