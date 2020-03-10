package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exc_078_SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        //Arrays.sort(nums);
        for (int i = 0; i <= len; i++) {
            subsets(nums, len, i, 0, lists, tempList);
        }
        return lists;
    }

    private void subsets(int[] nums, int len, int size, int start, List<List<Integer>> lists, List<Integer> tempList) {
        if (size == tempList.size()) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        if (len - start < size) return;
        for (int i = start; i < len; i++) {
            tempList.add(nums[i]);
            subsets(nums, len, size, i + 1, lists, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Exc_078_SubSets ss = new Exc_078_SubSets();
        int[] a = {1, 2, 3};
        System.out.println(ss.subsets(a));
    }
}
