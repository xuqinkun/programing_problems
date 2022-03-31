package leetcode.easy.tree;

import leetcode.util.TreeNode;

public class Exc_617_MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        else if (t1 == null) return t2;
        else if (t2 == null) return t1;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = TreeNode.fromArray(new int[]{1, 3, 2, 5});
        TreeNode t2 = TreeNode.fromArray(new int[]{2, 1, 3, -1, -1, 4, 7});
        Exc_617_MergeTrees mt = new Exc_617_MergeTrees();
        TreeNode root = mt.mergeTrees(t1, t2);
        TreeNode.print(root);
    }
}
