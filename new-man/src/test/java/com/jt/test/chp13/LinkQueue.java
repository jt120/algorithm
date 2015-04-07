package com.jt.test.chp13;

import com.jt.test.api.Queue;

import java.util.Iterator;

/**
 * since 2015/4/7.
 */
public class LinkQueue<T> implements Queue<T> , Iterable<T>{

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    @Override
    public void enqueue(T t) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = t;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;

    }

    @Override
    public T dequeue() {
        T t = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        size--;
        return t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }


    private class Node<T> {
        T item;
        Node<T> next;
    }

    private class NodeIterator implements Iterator<T> {

        private Node<T> cur = first;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T item = cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
