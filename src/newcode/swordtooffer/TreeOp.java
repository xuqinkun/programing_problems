package newcode.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOp {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null) return null;
        // 1. 有右子树,返回右子树的最左结点
        if (pNode.right != null) {
            return getLeftMostNode(pNode.right);
        } else { // 无右子树
            TreeLinkNode parent = pNode.next, child = pNode;
            while (parent != null && parent.right == child) {
                child = parent;
                parent = parent.next;
            }
            if (parent == null) {
                return null;
            } else {
                return parent;
            }
        }
    }

    private TreeLinkNode getLeftMostNode(TreeLinkNode pNode) {
        TreeLinkNode node = pNode;
        while (node.left != null)
            node = node.left;
        return node;
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return isSymmetrical(left.right, right.left)
                    && isSymmetrical(left.left, right.right);
        }
        return false;
    }

    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int levelCount = 1, count = 0;
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (levelCount-- > 0) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
            }
            if (!temp.isEmpty()) {
                if (isReverse) { //从右至左打印
                    Stack<Integer> stack = new Stack<>();
                    stack.addAll(temp);
                    temp.clear();
                    while (!stack.isEmpty()) {
                        temp.add(stack.pop());
                    }
                }
                lists.add(temp);
            }
            levelCount = count;
            count = 0;
            isReverse = !isReverse;
        }
        return lists;
    }

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        if(pRoot == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int levelCount = 1, count = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (levelCount-- > 0) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
            }
            if (!temp.isEmpty()) {
                lists.add(temp);
            }
            levelCount = count;
            count = 0;
        }
        return lists;
    }

    TreeNode getTreeByLevel(String [] a) {
        int len = a.length;
        if (len == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(a[index]));
        queue.add(root);
        while (!queue.isEmpty() && index < len) {
            index++;
            TreeNode curr = queue.remove();
            if (index < len && !a[index].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(a[index]));
                queue.add(curr.left);
            }
            index++;
            if (index < len && !a[index].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(a[index]));
                queue.add(curr.right);
            }
        }
        return root;
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.trim().isEmpty()) return null;
        String[] values = str.split(",");
        return Deserialize(values);
    }

    int index = 0;
    private TreeNode Deserialize(String[] values) {
        if (index > values.length || values[index].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;
        root.left = Deserialize(values);
        index++;
        root.right = Deserialize(values);
        return root;
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = pRoot;
        do {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            k--;
            if (k == 0) return t;
            t = t.right;
        } while (!stack.isEmpty() || t != null);
        return null;
    }

    TreeNode KthNode(TreeNode pRoot, int [] num)
    {
        if (pRoot == null) return null;
        TreeNode node;
        if ((node = KthNode(pRoot.left, num)) != null) return node;
        num[0]--;
        if (num[0] == 0) return pRoot;
        if ((node = KthNode(pRoot.right, num)) != null) return node;
        return null;
    }

    void inOrderWithStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        do {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            System.out.println(t.val);
            t = t.right;
        } while (!stack.isEmpty() || t != null);
    }

    public static void main(String[] args) {
        TreeOp op = new TreeOp();
        String[] values = "8,6,10,5,7,9,11".split(",");
        TreeNode tree = op.getTreeByLevel(values);
//        String s = op.Serialize(tree);
//        System.out.println(s);
//        TreeNode d = op.Deserialize(s);
//        System.out.println(d);
        TreeNode kthNode = op.KthNode(tree, 1);
        System.out.println(kthNode.val);
//        op.inOrderWithStack(tree);
    }
}