package leetcode.easy.tree;

import leetcode.util.TreeNode;

import java.util.Stack;

public class Exc_938_RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;

        stack.push(root);
        while (curr.left != null) {
            curr = curr.left;
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        int currVal = root.val;
        int tmpVal = 0;
        if (currVal >= low && currVal <= high) {
            tmpVal = currVal;
        }
        if (root.left != null) {
            tmpVal += rangeSumBST2(root.left, low, high);
        }
        if (root.right != null) {
            tmpVal += rangeSumBST2(root.right, low, high);
        }
        return tmpVal;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree(new int[]{10, 5, 15, 3, 7, -1, 18});
        TreeNode root2 = TreeNode.arrayToTree(new int[]{10,5,15,3,7,13,18,1,-1,6});
        Exc_938_RangeSumBST sum = new Exc_938_RangeSumBST();
        System.out.println(sum.rangeSumBST2(root2, 6, 10));
    }

}
