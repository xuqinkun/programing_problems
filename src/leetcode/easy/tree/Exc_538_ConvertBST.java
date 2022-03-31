package leetcode.easy.tree;

import leetcode.util.TreeNode;

public class Exc_538_ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode root, int sum) {
        if (root == null) return 0;
        int right = convertBST(root.right, sum);
        int rootVal = root.val;
        root.val += right + sum;
        int left = convertBST(root.left, root.val);

        return left + rootVal + right;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new int[]{6, 4, 10, 2, 5, 7, 11});
        Exc_538_ConvertBST cb = new Exc_538_ConvertBST();
        cb.convertBST(root);

    }
}
