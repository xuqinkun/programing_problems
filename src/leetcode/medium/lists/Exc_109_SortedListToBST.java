package leetcode.medium.lists;

import leetcode.easy.tree.TreeNode;

import java.util.ArrayList;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_109_SortedListToBST
 * Author:   Xu Qinkun
 * Date:     2020/3/22 9:06
 * Description:
 */

public class Exc_109_SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        Integer[] nums = list.toArray(new Integer[0]);
        return arrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBST(Integer[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToBST(nums, left, mid - 1);
        node.right = arrayToBST(nums, mid + 1, right);
        return node;
    }
}
