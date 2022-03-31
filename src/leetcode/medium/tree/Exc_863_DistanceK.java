package leetcode.medium.tree;

import leetcode.util.TreeNode;

import java.util.*;

public class Exc_863_DistanceK {
    Map<Integer, TreeNode> parentIndex = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        // 通过层次遍历建立父节点索引
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            if (parent.left != null) {
                parentIndex.put(parent.left.val, parent);
                queue.add(parent.left);
                size++;
            }
            if (parent.right != null) {
                parentIndex.put(parent.right.val, parent);
                queue.add(parent.right);
                size++;
            }
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(target);
        List<Integer> ret = new ArrayList<>();
        boolean[] accessFlag = new boolean[size + 1];
        accessFlag[target.val] = true;
        // 通过深度优先搜索找第k个结点
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            while (stack.size() - 1 < k && curr != null) {
                if (curr.left != null && !accessFlag[curr.left.val]) {
                    stack.push(curr.left);
                    accessFlag[curr.left.val] = true;
                    curr = curr.left;
                }
                else if (curr.right != null && !accessFlag[curr.right.val]) {
                    stack.push(curr.right);
                    accessFlag[curr.right.val] = true;
                    curr = curr.right;
                }
                else if (parentIndex.containsKey(curr.val) && parentIndex.get(curr.val) != null && !accessFlag[parentIndex.get(curr.val).val]) {
                    stack.push(parentIndex.get(curr.val));
                    accessFlag[parentIndex.get(curr.val).val] = true;
                    curr = parentIndex.get(curr.val);
                } else {
                    break;
                }
            }
            TreeNode top = stack.pop();
            if (stack.size() == k) {
                ret.add(top.val);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        Exc_863_DistanceK distanceK = new Exc_863_DistanceK();
        List<Integer> ret = distanceK.distanceK(root, root.left, 5);
        System.out.println(ret);
    }
}
