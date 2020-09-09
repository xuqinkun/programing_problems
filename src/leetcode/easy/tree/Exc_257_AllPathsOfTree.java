package leetcode.easy.tree;


import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Exc_257_AllPathsOfTree {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), root);
        return ret;
    }

    private void dfs(List<String> ret, List<Integer> tmp, TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
            ret.add(format(tmp));
            if (tmp.size() > 0) {
                tmp.remove(tmp.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            tmp.add(root.val);
            dfs(ret, tmp, root.left);
            if (tmp.size() > 0) {
                tmp.remove(tmp.size() - 1);
            }
        }
        if (root.right != null) {
            tmp.add(root.val);
            dfs(ret, tmp, root.right);
            if (tmp.size() > 0) {
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private String format(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i));
            if (i != nums.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    private void dfs2(List<String> ret, String path, TreeNode root) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(root.val);
            path = pathSB.toString();
            if (root.left == null && root.right == null) {
                ret.add(path);
            } else {
                pathSB.append("->");
                path = pathSB.toString();
                dfs2(ret, path, root.left);
                dfs2(ret, path, root.left);
            }
        }
    }
}