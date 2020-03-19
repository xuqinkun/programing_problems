package leetcode.medium.lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: LRUDemo
 * Author:   Xu Qinkun
 * Date:     2020/3/19 9:17
 * Description:
 */

public class LRUDemo {
    final int maxCount;
    DNode head, tail;
    Map<String, DNode> index;

    public LRUDemo(int maxCount) {
        this.maxCount = maxCount;
        index = new HashMap<>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    static class DNode {
        String key;
        int val;
        DNode next, prev;

        public DNode() {
        }

        public DNode(String key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "DNode{" +
                    "key='" + key + '\'' +
                    ", val=" + val +
                    '}';
        }
    }

    public void save(String key, int value) {
        System.out.printf("============Save(%s, %s)============\n", key, value);
        if (index.containsKey(key)) {
            System.err.printf("Already saved(key=[%s])\n", key);
            return;
        }
        if (index.size() == maxCount) {
            DNode old = head.next;
            head.next = old.next;
            old.next.prev = head;
            old.next = null;
            old.prev = null;
            index.remove(old.key);
        }
        DNode newNode = new DNode(key, value);
        DNode last = tail.prev;
        last.next = newNode;
        newNode.prev = last;
        newNode.next = tail;
        tail.prev = newNode;
        index.put(key, newNode);
    }

    public int get(String key) {
        System.out.printf("============Get(%s)============\n", key);
        if (!index.containsKey(key)) {
            System.err.printf("Can't find page(key=[%s])\n", key);
            return -1;
        }
        DNode target = index.get(key);
        target.prev.next = target.next;
        target.next.prev = target.prev;
        DNode last = tail.prev;
        last.next = target;
        target.prev = last;
        target.next = tail;
        tail.prev = target;
        return target.val;
    }

    public void print() {
        DNode curr = head.next;
        while (curr != tail) {
            System.out.printf("(%s,%d)", curr.key, curr.val);
            if (curr.next != tail)
                System.out.printf("->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUDemo lru = new LRUDemo(3);
        lru.save("key2", 2);
        lru.print();
        lru.save("key3", 3);
        lru.print();
        lru.save("key4", 4);
        lru.print();
        System.out.println(lru.get("key2"));
        lru.print();
        lru.save("key5", 5);
        lru.print();
        System.out.println(lru.get("key2"));
        lru.print();
        lru.save("key6", 6);
        lru.print();

    }
}
