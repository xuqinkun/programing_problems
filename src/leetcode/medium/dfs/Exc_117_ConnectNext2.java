package leetcode.medium.dfs;

import static leetcode.medium.dfs.Exc_116_ConnectNext.arrayToTree;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_116_ConnectNext
 * Author:   Xu Qinkun
 * Date:     2020/3/26 9:01
 * Description: 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 */

public class Exc_117_ConnectNext2 {

    public Node connect(Node root) {
        if (root == null) return null;
        root.next = null;
        Node leftMost = root;
        while (leftMost != null) {
            Node p = leftMost;
            Node curr = new Node(-1);
            while (p != null) {
                if (p.left != null) {
                    curr.next = p.left;
                    curr = curr.next;
                }
                if (p.right != null) {
                    curr.next = p.right;
                    curr = curr.next;
                }
                p = p.next;
            }
            while (leftMost != null && leftMost.left == null && leftMost.right == null)
                leftMost = leftMost.next;
            if (leftMost == null)
                break;
            if (leftMost.left == null)
                leftMost = leftMost.right;
            else
                leftMost = leftMost.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Exc_117_ConnectNext2 cn = new Exc_117_ConnectNext2();
        int[] a = {3,9,20,-1,-1,15,7};
        Node root = arrayToTree(a);
        cn.connect(root);
    }
}
