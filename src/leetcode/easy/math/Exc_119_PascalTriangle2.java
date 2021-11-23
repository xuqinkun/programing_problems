package leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class Exc_119_PascalTriangle2 {

    public List<Integer> generate(int rowIndex) {
        List<Integer> lastLevelList = new ArrayList<>();
        List<Integer> currLevelList = new ArrayList<>();
        lastLevelList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currLevelList.add(1);
                }
                else {
                    currLevelList.add(lastLevelList.get(j-1) + lastLevelList.get(j));
                }
            }
            lastLevelList = new ArrayList<>(currLevelList);
            currLevelList.clear();
        }
        return lastLevelList;
    }

    public static void main(String[] args) {
        Exc_119_PascalTriangle2 pt = new Exc_119_PascalTriangle2();
        System.out.println(pt.generate(0));
        System.out.println(pt.generate(1));
        System.out.println(pt.generate(2));
        System.out.println(pt.generate(3));
    }
}
