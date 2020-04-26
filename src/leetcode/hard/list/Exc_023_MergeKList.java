package leetcode.hard.list;

import leetcode.util.ListNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_023_MergeKList
 * Author:   Xu Qinkun
 * Date:     2020/4/26 10:12
 * Description: 合并K个排序链表
 */

public class Exc_023_MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftList = mergeKLists(lists, left, mid);
        ListNode rightList = mergeKLists(lists, mid + 1, right);
        return merge(leftList, rightList);
    }

    private ListNode merge(ListNode leftList, ListNode rightList) {
        ListNode head = new ListNode(0), curr = head;
        ListNode p = leftList, q = rightList;
        while (p != null && q != null) {
            if (p.val < q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        if (p!=null) {
            curr.next=p;
        }
        if (q!=null) {
            curr.next=q;
        }
        return head.next;
    }
}
