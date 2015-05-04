package com.jt.test.chp13;

import com.jt.test.api.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * since 2015/4/7.
 */
public class LinkStack <T> implements Stack<T>, Iterable<T> {

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
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("not find");
        }
        return first.t;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node<T> {
        T t;
        Node<T> next;
    }

    private class StackIterator<T> implements Iterator<T> {
        private Node cur = first;
        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) throws Exception {
    }
}
