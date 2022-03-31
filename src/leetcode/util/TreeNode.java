package leetcode.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (C), 2018-2020
 * FileName: TreeNode
 * Author:   Xu Qinkun
 * Date:     2020/3/16 9:51
 * Description:
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static TreeNode fromArray(int[] arr) {
        int n = arr.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            TreeNode node = queue.remove();
            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < n && arr[i] != -1) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                sb.append(node.val);
                if (!queue.isEmpty())
                    sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}
