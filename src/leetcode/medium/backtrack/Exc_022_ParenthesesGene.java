package leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Exc_022_ParenthesesGene {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, n, 0, 0, "");
        return list;
    }

    private void backtrack(List<String> list, int max, int open, int close, String ans) {
        if (ans.length() == max * 2) {
            list.add(ans);
            return;
        }
        if (open < max) {
            backtrack(list, max, open + 1, close, ans + "(");
        }
        if (close < open) {
            backtrack(list, max, open, close + 1, ans + ")");
        }
    }

    public static void main(String[] args) {
        Exc_022_ParenthesesGene pg = new Exc_022_ParenthesesGene();
        List<String> strings = pg.generateParenthesis(3);
        System.out.println(strings);
    }
}
