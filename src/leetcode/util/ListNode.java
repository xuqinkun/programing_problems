package leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public static ListNode arrayToList(int [] a) {
        int n = a.length;
        if (n == 0) return null;
        ListNode head = new ListNode(0), curr = head;
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(a[i]);
            curr = curr.next;
        }
        return head.next;
    }

    public static ListNode constructCycleList(int [] a, int idx) {
        int n = a.length;
        if (n == 0) return null;
        ListNode head = new ListNode(0), curr = head, tmp = null;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(a[i]);
            curr.next = node;
            if (idx-- == 0) {
                tmp = node;
            }
            curr = curr.next;
        }
        curr.next = tmp;
        return head.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void printListNode(ListNode list) {
        ListNode p = list;
        while (p != null) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print("->");
            }
            p = p.next;
        }
        System.out.println();
    }
}
