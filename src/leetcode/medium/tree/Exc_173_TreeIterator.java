package leetcode.medium.tree;

import leetcode.util.TreeNode;

import java.util.Stack;

class BSTIterator {
    TreeNode curr;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        curr = root;
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode node = stack.pop();
        curr = node.right;
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
    }
}

public class Exc_173_TreeIterator {

}
