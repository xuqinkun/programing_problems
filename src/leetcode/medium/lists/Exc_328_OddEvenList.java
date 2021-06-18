package leetcode.medium.lists;

import leetcode.util.ListNode;

import static leetcode.util.ListUtil.arrayToList;
import static leetcode.util.ListUtil.printListNode;

public class Exc_328_OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0), evenHead = new ListNode(0);
        ListNode curr1 = oddHead, curr2 = evenHead, curr = head;
        while (curr1 != null && curr2 != null && curr != null && curr.next != null) {
            curr1.next = curr;
            curr2.next = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;

            curr = curr.next.next;
        }
        curr1.next = null;
        curr2.next = null;
        if (curr != null) {
            curr1.next = curr;
            curr1 = curr1.next;
        }
        curr1.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode head = arrayToList(new int[]{1, 2, 3, 4, 5});
        Exc_328_OddEvenList oel = new Exc_328_OddEvenList();
        ListNode ret = oel.oddEvenList(head);
        printListNode(ret);
    }
}
