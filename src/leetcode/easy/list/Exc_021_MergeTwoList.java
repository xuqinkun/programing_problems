package leetcode.easy.list;

import leetcode.util.ListNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_021_MergeTwoList
 * Author:   Xu Qinkun
 * Date:     2020/5/2 9:25
 * Description:
 */

public class Exc_021_MergeTwoList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = l1, q = l2, curr = head;
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
        if (p != null)
            curr.next = p;
        if (q != null)
            curr.next = q;
        return head.next;
    }
}
