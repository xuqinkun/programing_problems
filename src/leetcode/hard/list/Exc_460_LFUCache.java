package leetcode.hard.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_460_LFUCache
 * Author:   Xu Qinkun
 * Date:     2020/4/5 10:55
 * Description:
 */

public class Exc_460_LFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        System.out.println(cache.get(13)); // -1
        cache.put(2, 19);
        System.out.println(cache.get(2)); // 19
        System.out.println(cache.get(3)); // 17
        cache.put(5, 25);
        System.out.println(cache.get(8)); // -1
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.println(cache.get(11)); // -1
        cache.put(9, 12);
        System.out.println(cache.get(7)); // -1
        System.out.println(cache.get(5)); // 5
        System.out.println(cache.get(8)); // -1
        System.out.println(cache.get(9)); // 12
        cache.put(4, 30);
        cache.put(9, 3);
        System.out.println(cache.get(9)); // 3
        System.out.println(cache.get(10)); // 5
        System.out.println(cache.get(10)); // 5
        cache.put(6, 14);
        cache.put(3, 1);
        System.out.println(cache.get(3)); // 1
        cache.put(10, 11);
        System.out.println(cache.get(8)); // -1
        cache.put(2, 14);
        System.out.println(cache.get(1)); // 30
        System.out.println(cache.get(5)); // 5
        System.out.println(cache.get(4)); // 30
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        System.out.println(cache.get(13)); // -1
        cache.put(7, 23);
        System.out.println(cache.get(8)); // -1
        System.out.println(cache.get(12)); // 24
        cache.put(3, 27);
        cache.put(2, 12);
        System.out.println(cache.get(5)); // 18
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        System.out.println(cache.get(6)); // 14
        cache.put(9, 29);
        cache.put(8, 21);
        System.out.println(cache.get(5)); //18
    }
}

class LFUCache {
    int capacity, size;
    LFUNode head, tail;
    Map<Integer, LFUNode> index;

    static class LFUNode {
        int key;
        int value;
        int n;
        LFUNode next, prev;

        public LFUNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.n = 0;
        }

        @Override
        public String toString() {
            return "LFUNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", n=" + n +
                    '}';
        }
    }

    public LFUCache(int capacity) {
        head = new LFUNode(-1, 0);
        tail = new LFUNode(-2, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
        index = new HashMap<>();
    }

    public int get(int key) {
        if (size == 0 || head.next == tail || !index.containsKey(key)) {
            return -1;
        }
        LFUNode currNode = index.get(key), tmp = currNode.next;
        currNode.n++;
        while (tmp != tail && tmp.n <= currNode.n) {
            tmp = tmp.next;
        }
        if (tmp != currNode.next)
            insertInto(currNode, tmp);
        return currNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (!index.containsKey(key) && size == capacity) {
            LFUNode oldNode = head.next;
            head.next = oldNode.next;
            oldNode.next.prev = head;
            index.remove(oldNode.key);
            size--;
        }
        LFUNode currNode, tmp;
        if (index.containsKey(key)) {
            currNode = index.get(key);
            currNode.value = value;
            currNode.n++;
            tmp = currNode.next;
        } else {
            currNode = new LFUNode(key, value);
            index.put(key, currNode);
            tmp = head.next;
            size++;
        }
        while (tmp != tail && tmp.n <= currNode.n) {
            tmp = tmp.next;
        }
        if (tmp != currNode.next)
            insertInto(currNode, tmp);
    }

    private void insertInto(LFUNode currNode, LFUNode target) {
        remove(currNode);
        currNode.next = target;
        currNode.prev = target.prev;
        target.prev.next = currNode;
        target.prev = currNode;
    }

    private void remove(LFUNode currNode) {
        LFUNode prev = currNode.prev;
        LFUNode next = currNode.next;
        if (prev == null || next == null) {
            return;
        }
        next.prev = prev;
        prev.next = next;
    }
}