package leetcode.medium.lists;

import leetcode.util.ListNode;
import leetcode.util.ListUtil;

import static leetcode.util.ListUtil.printListNode;

public class Exc_143_ReorderList {

    public void reorderList(ListNode head) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        int mid = (cnt + 1) / 2;
        ListNode rightHead = null;
        p = head;
        for (int i = 0;i < mid - 1; i++) {
            p = p.next;
        }
        rightHead = p.next;
        rightHead = reverse(rightHead);
        p.next = null;
        p = head;
        while (rightHead != null) {
            ListNode temp = rightHead;
            rightHead = rightHead.next;
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = head, curr, next = head.next;
        prev.next = null;
        while(next != null) {
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = ListUtil.stringToListNode("1");
        Exc_143_ReorderList rl = new Exc_143_ReorderList();
        rl.reorderList(listNode);
        printListNode(listNode);
    }
}
