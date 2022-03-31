package leetcode.easy.tree;

import leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exc_235_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, Integer> union = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        union.put(root.val, -1);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    union.put(node.left.val, node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    union.put(node.right.val, node.val);
                }
            }
        }
        return new TreeNode(lowestCommonAncestor(union, p.val, q.val));
    }

    // The best algorithm
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val, pVal = p.val, qVal = q.val;
        if (rootVal < pVal && rootVal < qVal) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        else if (rootVal > pVal && rootVal>qVal) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        else {
            return root;
        }
    }

    private int lowestCommonAncestor(Map<Integer, Integer> union, int left, int right) {
        // If left is ancestor of right
        int temp = right;
        while (union.get(temp) != -1) {
            if (union.get(temp) == left) {
                return left;
            }
            temp = union.get(temp);
        }
        temp = left;
        while (union.get(temp) != -1) {
            if (union.get(temp) == right) {
                return right;
            }
            temp = union.get(temp);
        }
        if (union.get(left).equals(union.get(right))) {
            return union.get(left);
        }
        return lowestCommonAncestor(union, union.get(left), union.get(right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new int[]{6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5});
        Exc_235_LowestCommonAncestor lca = new Exc_235_LowestCommonAncestor();
        TreeNode ancestor = lca.lowestCommonAncestor2(root, new TreeNode(3), new TreeNode(5));
        System.out.println(ancestor.val);
    }
}
