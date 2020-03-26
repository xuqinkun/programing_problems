package leetcode.medium.dfs;

import java.util.LinkedList;
import java.util.Queue;

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
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Exc_116_ConnectNext {

    public Node connect(Node root) {
        if (root == null) return null;
        root.next = null;
        Node leftMost = root;
        while (leftMost != null) {
            Node p = leftMost;
            Node curr = new Node(-1);
            while (p != null && p.left != null) {
                curr.next = p.left;
                curr = curr.next;
                curr.next = p.right;
                curr = curr.next;
                p = p.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public static Node arrayToTree(int [] arr) {
        int n = arr.length;
        if (n == 0) return null;
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            Node node = queue.remove();
            if (arr[i] != -1) {
                node.left = new Node(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < n && arr[i] != -1) {
                node.right = new Node(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Exc_117_ConnectNext2 cn = new Exc_117_ConnectNext2();
        int[] a = {1,2,3,4,5,6,7};
        Node root = arrayToTree(a);
        cn.connect(root);
    }
}
