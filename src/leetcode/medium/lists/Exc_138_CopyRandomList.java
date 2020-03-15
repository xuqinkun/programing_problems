package leetcode.medium.lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: CopyRandomList
 * Author:   Xu Qinkun
 * Date:     2020/3/15 10:17
 * Description:
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                " random=" + random +
                '}';
    }
}

public class Exc_138_CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head, pre, ans;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        pre = head;
        curr = head.next;
        ans = curr;
        while (curr != null) {
            if(pre.random != null)
                curr.random = pre.random.next;
            if (curr.next == null) break;
            pre = curr.next;
            curr = pre.next;
        }
        pre = head;
        curr = ans;
        while (curr != null) {
            pre.next = curr.next;
            pre = pre.next;
            if (pre == null) break;
            curr.next = pre.next;
            curr = curr.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] a = {{7,-1},{13,0},{11,4},{10,2},{1,0}};
        Node head = constructRandomList(a);
        Exc_138_CopyRandomList cpr = new Exc_138_CopyRandomList();
        Node copy = cpr.copyRandomList(head);
        printNode(copy);
    }

    static void printNode(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p);
            if (p.next != null) {
                System.out.print("->");
            }
            p = p.next;
        }
        System.out.println();
    }

    private static Node constructRandomList(int[][] a) {
        Node head = new Node(-1), curr = head;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Node node = new Node(a[i][0]);
            curr.next = node;
            curr = curr.next;
            map.put(i, node);
        }
        curr = head.next;
        for (int i = 0; i < a.length; i++) {
            int randIndex = a[i][1];
            if (randIndex != -1) {
                curr.random = map.get(randIndex);
            }
            curr = curr.next;
        }
        return head.next;
    }
}
