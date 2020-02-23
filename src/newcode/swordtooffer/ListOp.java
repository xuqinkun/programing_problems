package newcode.swordtooffer;

public class ListOp {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getList(int [] a) {
        ListNode head = new ListNode(0), p = head;
        for (int i : a) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode fast = pHead, slow = pHead;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        ListNode p = pHead, q = fast;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode p = pHead, newHead = new ListNode(0), prev = newHead;
        prev.next = pHead;
        int lastVal;
        boolean hasRepeat;
        while (p != null) {
            lastVal = p.val;
            p = p.next;
            hasRepeat = false;
            while (p!= null && lastVal == p.val) {
                p = p.next;
                hasRepeat = true;
            }
            if (hasRepeat) {
                prev.next = p;
            } else {
                prev = prev.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListOp op = new ListOp();
        int[] a = {1, 2, 3, 3, 4, 4, 5};
        ListNode list = op.getList(a);
        op.deleteDuplication(list);
    }
}
