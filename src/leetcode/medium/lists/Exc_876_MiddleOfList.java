package leetcode.medium.lists;

import leetcode.util.ListNode;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_876_MiddleOfList
 * Author:   Xu Qinkun
 * Date:     2020/3/23 9:15
 * Description: 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */

public class Exc_876_MiddleOfList {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
