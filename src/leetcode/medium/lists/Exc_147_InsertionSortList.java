package leetcode.medium.lists;

import leetcode.util.ListNode;
import leetcode.util.ListUtil;

import static leetcode.util.ListUtil.printListNode;

public class Exc_147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead = new ListNode(0), curr = sortedHead;
        ListNode temp = new ListNode(Integer.MAX_VALUE);
        temp.next = head;
        head = temp;
        while (head.next != null) {
            ListNode p = head;
            int min = p.val;
            ListNode prev = null, target = null;
            for (ListNode pre = p, q = p.next; q != null; pre = pre.next, q = q.next) {
                if (q.val < min) {
                    min = q.val;
                    prev = pre;
                    target = q;
                }
            }
            if (target != null) {
                prev.next = target.next;
                curr.next = target;
                curr = curr.next;
            }
        }
        return sortedHead.next;
    }

    public static void main(String[] args) {
        Exc_147_InsertionSortList isl = new Exc_147_InsertionSortList();
        ListNode l = ListUtil.stringToListNode("0");
        printListNode(l);
        ListNode l2 = isl.insertionSortList(l);
        printListNode(l2);
    }
}
