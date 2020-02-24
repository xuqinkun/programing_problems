package leetcode.medium.lists;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 */

public class Exc_445_SumOfTwo {

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0), carryList = new ListNode(0);
        ListNode p = l1, q = l2, curr1 = sumList, curr2 = carryList, start1, start2;
        int len1 = 0, len2 = 0, sum, d;
        int bitsOfSum = 0, bitsOfCarry = 0;
        for ( ; p != null; p = p.next) len1++;
        for ( ; q != null; q = q.next) len2++;

        if (len1 > len2) {
            p = l1; q = l2;
            d = len1 - len2;
        } else {
            p = l2; q = l1;
            d = len2 - len1;
        }
        while (d-- > 0) {
            curr1.next = new ListNode(p.val);
            curr1 = curr1.next;
            p = p.next;
            bitsOfSum++;
        }
        start1 = p; start2 = q;
        while (p != null) {
            sum = p.val + q. val;
            curr1.next = new ListNode(sum % 10);
            curr1 = curr1.next;
            p = p.next; q = q.next;
            bitsOfSum++;
        }
        p = start1; q = start2;
        while (p != null) {
            curr2.next = new ListNode((p.val + q.val) / 10);
            curr2 = curr2.next;
            p = p.next; q = q.next;
            bitsOfCarry++;
        }
        curr2.next = new ListNode(0);
        bitsOfCarry++;
        curr1 = sumList.next;
        curr2 = carryList.next;
        d = bitsOfCarry - bitsOfSum;
        while (d-- > 0) {
            curr2 = curr2.next;
        }
        while (curr2 != null) {
            curr2.val += curr1.val;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return carryList.next;
    }*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode head = new ListNode(0), p = l1, q = l2;
        int carry = 0, sum = 0;
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        while (q != null) {
            s2.push(q.val);
            q = q.next;
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            insert(head, sum % 10);
        }
        while (!s1.isEmpty()) {
            sum = s1.pop() + carry;
            carry = sum / 10;
            insert(head, sum % 10);
        }
        while (!s2.isEmpty()) {
            sum = s2.pop() + carry;
            carry = sum / 10;
            insert(head, sum % 10);
        }
        if (carry != 0) {
            insert(head, carry);
        }
        return head.next;
    }

    private void insert(ListNode head, int i) {
        ListNode node = new ListNode(i);
        node.next = head.next;
        head.next = node;
    }


    public static void main(String[] args) {
        ListNode l1 = Test.stringToListNode("1,2");
        ListNode l2 = Test.stringToListNode("9");
        Exc_445_SumOfTwo st = new Exc_445_SumOfTwo();
        ListNode ans = st.addTwoNumbers(l1, l2);
        Test.printListNode(l1);
        Test.printListNode(l2);
        Test.printListNode(ans);
    }
}
