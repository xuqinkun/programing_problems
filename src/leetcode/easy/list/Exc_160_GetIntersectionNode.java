package leetcode.easy.list;

import leetcode.util.ListNode;
import leetcode.util.ListUtil;

public class Exc_160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.arrayToList(new int[]{2, 4, 6});
        ListNode l2 = ListUtil.arrayToList(new int[]{1,5});
        Exc_160_GetIntersectionNode gn = new Exc_160_GetIntersectionNode();
        gn.getIntersectionNode(l1, l2);
    }

}
