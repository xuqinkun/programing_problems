package leetcode.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node arrayToTree(int[] arr) {
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

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
};

public class Exc_117_ConnectRightNode {

    public Node connect(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        while (true) {
            Node q = leftmost;
            Node curr = new Node();
            while (q != null) {
                if (q.left != null) {
                    curr.next = q.left;
                    curr = curr.next;
                }
                if (q.right != null) {
                    curr.next = q.right;
                    curr = curr.next;
                }
                q = q.next;
            }
            while (leftmost!=null&&leftmost.left==null&&leftmost.right==null)
                leftmost = leftmost.next;
            if (leftmost == null)
                break;
            if (leftmost.left != null)
                leftmost = leftmost.left;
            else
                leftmost = leftmost.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = Node.arrayToTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        Exc_117_ConnectRightNode crn = new Exc_117_ConnectRightNode();
        crn.connect(root);
    }
}
