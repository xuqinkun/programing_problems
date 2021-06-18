package leetcode.medium.lists;

import leetcode.util.ListNode;
import leetcode.util.ListUtil;

public class Exc_086_ListPartition {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pre = new ListNode(0), curr = head;
        pre.next = head;
        head = pre;

        while (curr != null && curr.val < x) {
            pre = curr;
            curr = curr.next;
        }
        if (curr == null) return head.next;
        ListNode tmp = curr;
        curr = curr.next;
        while (curr != null) {
            if (curr.val < x) {
                ListNode next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                pre = pre.next;
                tmp.next = next;
                curr = next;
            } else {
                tmp = curr;
                curr = curr.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Exc_086_ListPartition lp = new Exc_086_ListPartition();
        int[] a = {1,4,3,2,5,2};
        ListNode list = lp.partition(ListUtil.arrayToList(a), 3);
        ListUtil.printListNode(list);
    }
}
