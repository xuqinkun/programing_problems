package leetcode.easy.tree;

import leetcode.util.TreeNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_543_DiameterOfBinaryTree
 * Author:   Xu Qinkun
 * Date:     2020/3/16 9:50
 * Description: 二叉树的直径
 */

public class Exc_543_DiameterOfBinaryTree {

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        diameterOfBinaryTree2(root);
        return max - 1;
    }

    private int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree2(root.left);
        int right = diameterOfBinaryTree2(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
