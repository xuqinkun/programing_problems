package leetcode.medium.tree;

import leetcode.util.TreeNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_098_ValidateBST
 * Author:   Xu Qinkun
 * Date:     2020/5/5 9:03
 * Description: 验证二叉搜索树
 */

public class Exc_098_ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left, (long) Integer.MIN_VALUE - 1, root.val) &&
                isValidBST(root.right, root.val, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }
}
