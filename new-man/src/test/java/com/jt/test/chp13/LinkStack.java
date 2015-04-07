package com.jt.test.chp13;

import com.jt.test.api.Stack;

/**
 * since 2015/4/7.
 */
public class LinkStack <T> implements Stack<T> {

    private Node<T> first;
    private int N;

    @Override
    public void push(T t) {
        Node old = first;
        first = new Node();
        first.t = t;
        first.next = old;
        N++;

    }

    @Override
    public T pop() {
        T t = first.t;
        first = first.next;
        N--;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    private class Node<T> {
        T t;
        Node<T> next;
    }
}
