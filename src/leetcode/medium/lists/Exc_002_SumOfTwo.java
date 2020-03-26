package leetcode.medium.lists;


import leetcode.util.ListNode;

public class Exc_002_SumOfTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode curr = sumList, p = l1, q = l2;
        int carry = 0, sum;
        while (p != null && q != null) {
            sum = p.val + q.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p.next;
            q = q.next;
        }
        while (p != null) {
            sum = p.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p.next;
        }
        while (q != null) {
            sum = q.val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            q = q.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return sumList.next;
    }
}
