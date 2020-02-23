package leetcode.medium.lists;

/**
 * Merge two sorted linked main.lists and return it as a new list. The new list should be made by splicing together the nodes of the first two main.lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class Exc_21_MergeTwoSortedLists {

    private static final int INITIAL_VALUE = -1;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1, cur2 = l2;
        ListNode resultList = new ListNode(INITIAL_VALUE), cur = resultList;
        while (cur1 != null && cur2 != null) {
            int nextValue;
            if (cur1.val < cur2.val) {
                nextValue = cur1.val;
                cur1 = cur1.next;
            } else {
                nextValue = cur2.val;
                cur2 = cur2.next;
            }
            cur.next = new ListNode(nextValue);
            cur = cur.next;
        }
        cur = checkTail(cur, cur1);
        cur = checkTail(cur, cur2);
        return resultList.next;
    }

    /**
     * Attention: 函数传递的是值，将引用传递给函数，原引用不会发生改变
     * @param cur1
     * @param cur2
     * @return
     */
    private ListNode checkTail(ListNode cur1, ListNode cur2) {
        while (cur2 != null) {
            cur1.next = new ListNode(cur2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private ListNode test(ListNode l) {
        System.out.println("Test for " + l.val);
        l.next = new ListNode(INITIAL_VALUE);
        l = l.next;
        return l;
    }

    private void print(final ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.printf("%d ", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        Exc_21_MergeTwoSortedLists demo = new Exc_21_MergeTwoSortedLists();
        ListNode cur = node;
        demo.test(cur);
        demo.print(node);
        demo.test(cur);
        demo.print(node);

    }
}
