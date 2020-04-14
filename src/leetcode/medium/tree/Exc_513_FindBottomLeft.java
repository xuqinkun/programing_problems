package leetcode.medium.tree;

import leetcode.util.TreeNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_513_FindBottomLevel
 * Author:   Xu Qinkun
 * Date:     2020/4/14 17:58
 * Description:
 */

public class Exc_513_FindBottomLeft {
    private int ans = 0;
    private boolean flag = true;

    public int findBottomLeftValue(TreeNode root) {
        int h = height(root);
        bottomLeft(root, h);
        return ans;
    }

    private void bottomLeft(TreeNode root, int h) {
        if (root == null) return;
        if (flag) {
            bottomLeft(root.left, h - 1);
        }
        if (h == 1) {
            ans = root.val;
            flag = false;
        }
        if (flag) {
            bottomLeft(root.right, h - 1);
        }
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4,-1, 5, 6,-1,-1,7};
        TreeNode t = TreeNode.arrayToTree(a);
        Exc_513_FindBottomLeft fb = new Exc_513_FindBottomLeft();
        System.out.println(fb.findBottomLeftValue(t));
    }
}
