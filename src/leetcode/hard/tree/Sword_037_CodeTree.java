package leetcode.hard.tree;

import leetcode.util.TreeNode;

import java.util.LinkedList;

public class Sword_037_CodeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            if (node != null)
                sb.append(node.val);
            else if (!queue.isEmpty())
                sb.append("null");
            if (!queue.isEmpty())
                sb.append(",");
        }
        String ans = sb.toString();
        while (ans.endsWith("null,")) {
            int idx = ans.lastIndexOf("null,");
            ans = ans.substring(0, idx);
        }
        return ans.substring(0, ans.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for(int i = 0; i < tokens.length; ) {
            String token = tokens[i++];
            if (!token.equals("null")) {
                int val = Integer.parseInt(token);
                if (queue.isEmpty()) {
                    root = new TreeNode(val);
                    queue.add(root);
                } else {
                    TreeNode node = queue.removeFirst();
                    node.left = new TreeNode(Integer.parseInt(token));
                    queue.add(node.left);
                    if (i < tokens.length) {
                        token = tokens[i++];
                        if (!token.equals("null")) {
                            node.right = new TreeNode(Integer.parseInt(token));
                            queue.add(node.right);
                        }
                    }
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.fromArray(new int[]{1, 2, 3, 4, -1, 5});
        Sword_037_CodeTree ct = new Sword_037_CodeTree();
        String ser = ct.serialize(root);
        System.out.println(ser);
        TreeNode node = ct.deserialize(ser);
        TreeNode.print(node);
    }
}
