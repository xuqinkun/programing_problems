package leetcode.util;

import leetcode.medium.lists.Exc_021_MergeTwoSortedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListUtil {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        //input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Exc_021_MergeTwoSortedLists().mergeTwoLists(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
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
