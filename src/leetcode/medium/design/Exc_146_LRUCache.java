package leetcode.medium.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Exc_146_LRUCache
 * Author:   Xu Qinkun
 * Date:     2020/3/22 9:45
 * Description: LRU缓存机制
 */

class LRUCache {
    DNode head, tail;
    int capacity, size;
    Map<Integer, DNode> cache;

    static class DNode {
        int key;
        int val;
        DNode next, prev;

        public DNode() {
        }

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    private DNode remove(DNode node) {
        if (node == null) return null;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        return node;
    }

    private DNode removeFirst() {
        if (head.next == tail) return null;
        DNode next = head.next;
        head.next = next.next;
        next.next.prev = head;
        next.next = null;
        next.prev = null;
        return next;
    }

    private void insert(DNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        DNode node = cache.get(key);
        int val = node.val;
        remove(node);
        insert(node);
        return val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DNode node = cache.get(key);
            node.val = value;
            remove(node);
            insert(node);
        } else {
            if (size == capacity) {
                DNode oldNode = removeFirst();
                if (oldNode != null) {
                    cache.remove(oldNode.key);
                    size--;
                }
            }
            DNode newNode = new DNode(key, value);
            insert(newNode);
            cache.put(key, newNode);
            size++;
        }
    }
}

public class Exc_146_LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        /*System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4*/
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
