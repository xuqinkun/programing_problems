package leetcode.medium.lists;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_142_DetectCycle
 * Author:   Xu Qinkun
 * Date:     2020/3/15 11:00
 * Description:
 */

public class Exc_142_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null) return null;
        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }

    public static void main(String[] args) {
        Exc_142_DetectCycle dc = new Exc_142_DetectCycle();
        int[] a = {3,2,0,-4};
        ListNode head = ListNode.constructCycleList(a, 1);
        ListNode ans = dc.detectCycle(head);
        System.out.println(ans.val);
    }
}
