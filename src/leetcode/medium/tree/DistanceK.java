package leetcode.medium.tree;

import leetcode.util.TreeNode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class DistanceK {
    List<TreeNode> branch = new ArrayList<>();

    private boolean found(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root.val == target.val) {
            branch.add(root);
            return true;
        }
        if (root.left != null || root.right != null) {
            boolean found = found(root.left, target) || found(root.right, target);
            if (found) {
                branch.add(root);
            }
            return found;
        }
        return false;
    }

    private int search(TreeNode root, TreeNode target, int dist) {
        int ret = 0;
        if (dist == 0 && root.val != target.val) {
            return root.val;
        }
        if (root.left != null) {
            ret = search(root.left, root, dist - 1);
        }
        if (ret == target.val && root.right != null) {
            ret = search(root.right, root, dist - 1);
        }
        if (ret == target.val)
            return search(target, root, dist);
        return ret;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        found(root, target);
        System.out.println(branch);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < branch.size(); i++) {
            ans.add(search(branch.get(i), branch.get(i - 1), k - i));
        }
        ans.add(search(branch.get(0), branch.get(branch.size() - 1), k));
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        List<Integer> ret = new DistanceK().distanceK(root, root.left, 2);
        System.out.println(ret);
    }
}
