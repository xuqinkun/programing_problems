package leetcode.medium.tree;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_199_RightSideView
 * Author:   Xu Qinkun
 * Date:     2020/4/22 9:25
 * Description:
 */

public class Exc_199_RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) return nums;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            int tmp = 0;
            while (levelCount-- > 0) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                    tmp++;
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    tmp++;
                }
                if (levelCount == 0) {
                    nums.add(p.val);
                }
            }
            levelCount = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.arrayToTree(new int[]{1,2,3,-1,5,-1,4,7});
        Exc_199_RightSideView rs = new Exc_199_RightSideView();
        System.out.println(rs.rightSideView(t));
    }
}
