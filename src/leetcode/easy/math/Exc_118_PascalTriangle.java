package leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class Exc_118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tempList.add(1);
                }
                else {
                    List<Integer> list = ans.get(i - 1);
                    tempList.add(list.get(j-1) + list.get(j));
                }
            }
            ans.add(tempList);
        }
        return ans;
    }

    public static void main(String[] args) {
        Exc_118_PascalTriangle pt = new Exc_118_PascalTriangle();
        System.out.println(pt.generate(1));
        System.out.println(pt.generate(2));
        System.out.println(pt.generate(5));
    }
}
