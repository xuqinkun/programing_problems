package leetcode.easy.stack;

import java.util.LinkedList;

public class Exc_225_MyStack {

    LinkedList<Integer> queue;
    /** Initialize your data structure here. */
    public Exc_225_MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
