package leetcode.medium.lists;

import leetcode.util.ListNode;

public class Exc_092_ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;
        ListNode pre = new ListNode(0), curr = pre, next, tail1, tail2;
        pre.next = head;
        head = pre;
        for (int i = 0; i < m - 1; i++) {
            curr = curr.next;
        }
        tail1 = curr;
        pre = null;
        curr = curr.next;
        tail2 = curr;
        for (int i = m; i <= n; i++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        tail1.next = pre;
        tail2.next = curr;
        return head.next;
    }

    public static void main(String[] args) {
        Exc_092_ReverseBetween rb = new Exc_092_ReverseBetween();
        int[] a = {1,2,3,4,5};
        ListNode listNode = ListNode.arrayToList(a);
        ListNode.printListNode(listNode);
        ListNode.printListNode(rb.reverseBetween(listNode, 1, 5));
    }
}
