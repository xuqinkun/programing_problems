package leetcode.medium.lists;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_MyQueue
 * Author:   Xu Qinkun
 * Date:     2020/3/15 12:24
 * Description:
 */

class MaxQueue {
    Node front1, rear1, front2, rear2;
    int max;
    int last;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public MaxQueue() {
        front1 = new Node(0);
        rear1 = front1;
        max = Integer.MIN_VALUE;
        last = max;
        front2 = new Node(max);
        rear2 = front2;
    }

    public int max_value() {
        System.out.printf("=====max_value=%d=====\n", max);
        System.out.println("front1:"+front1);
        System.out.println("front2:"+front2);
        if (front1 == rear1) return -1;
        return max;
    }

    public void push_back(int value) {
        System.out.printf("===push(%d)====\n", value);
        rear1.next = new Node(value);
        rear1 = rear1.next;
        Node newNode = new Node(value);
        if (value <= last) {
            rear2.next = newNode;
            rear2 = rear2.next;
        } else {
            Node curr = front2.next, pre = front2;
            while (curr != null && curr.val > value) {
                pre = curr;
                curr = curr.next;
            }
            pre.next = newNode;
            rear2 = newNode;
        }
        last = value;
        max = Math.max(max, value);
        System.out.printf("===after push(%d) max=%d ====\n", value, max);
        System.out.println("front1:"+front1);
        System.out.println("front2:"+front2);
    }

    public int pop_front() {
        System.out.println("=======pop()====");
        if (front1 == rear1) return -1;
        front1 = front1.next;
        int val = front1.val;
        if (val == max) {
            front2.next = front2.next.next;
            if (front2.next == null) {
                max = front2.val;
                last = max;
            } else {
                max = front2.next.val;
            }
        }
        System.out.printf("===after pop(%d) max=%d ====\n", val, max);
        System.out.println("front1:"+front1);
        System.out.println("front2:"+front2);
        return val;
    }
}

public class Exc_59_2_MaxQueue {

}
