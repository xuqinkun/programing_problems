package leetcode.easy.tree;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exc_107_LevelTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int tmp = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            while (tmp-- > 0) {
                TreeNode node = queue.remove();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(0, tmpList);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTree(new int[]{3, 9, 20, -1, -1, 15, 7});
        Exc_107_LevelTraversal2 exc = new Exc_107_LevelTraversal2();
        List<List<Integer>> ret = exc.levelOrderBottom(root);
        System.out.println(ret);
    }

}
