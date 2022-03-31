package leetcode.medium.dfs;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_113_PathSum
 * Author:   Xu Qinkun
 * Date:     2020/3/26 7:37
 * Description:
 */

public class Exc_113_PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        inOrder(root, sum, lists, tempList);
        return lists;
    }

    private void inOrder(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> tempList) {
        if (root == null) return;
        tempList.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            if (!tempList.isEmpty())
                lists.add(new ArrayList<>(tempList));
            return;
        }
        if (root.left != null) {
            inOrder(root.left, sum, lists, tempList);
            tempList.remove(tempList.size() - 1);
        }
        if (root.right != null) {
            inOrder(root.right, sum, lists, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,1};
        TreeNode root = TreeNode.fromArray(a);
        Exc_113_PathSum ps = new Exc_113_PathSum();
        System.out.println(ps.pathSum(root, 1));
    }
}
