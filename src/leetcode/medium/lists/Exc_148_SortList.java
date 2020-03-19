package leetcode.medium.lists;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_148_SortList
 * Author:   Xu Qinkun
 * Date:     2020/3/19 10:22
 * Description: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */

public class Exc_148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = head, list2 = slow.next;
        slow.next = null;
        list1 = sortList(list1);
        list2 = sortList(list2);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0), curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        curr = head;
        head = head.next;
        curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] a = {-1,5,3,4,0};
        ListNode head = ListNode.arrayToList(a);
        ListNode.printListNode(head);
        Exc_148_SortList sl = new Exc_148_SortList();
        ListNode sortedList = sl.sortList(head);
        ListNode.printListNode(sortedList);
    }
}
