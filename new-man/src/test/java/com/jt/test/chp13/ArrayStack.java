package com.jt.test.chp13;

import java.util.Iterator;

/**
 * since 2015/4/7.
 */
public class ArrayStack<T> implements Iterable<T> {

    private T[] ts;
    private int size;

    public ArrayStack(int cap) {
        ts = (T[]) new Object[cap];
    }

    public void push(T t) {
        if (size == ts.length) {
            resize(2 * ts.length);
        }
        ts[size++] = t;
    }

    public T pop() {
        T t = ts[--size];
        ts[size] = null;
        if (size > 0 && size == ts.length / 4) {
            resize(ts.length/2);
        }
        return t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int max) {
        T[] nt = (T[]) new Object[max];
        for (int i = 0; i < size; i++) {
            nt[i] = ts[i];
        }
        ts = nt;
    }

    public static void main(String[] args) throws Exception {
        ArrayStack<Integer> arrayStack = new ArrayStack(10);
        for (int i = 0; i < 15; i++) {
            arrayStack.push(i);
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(arrayStack.pop());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator();
    }

    private class ReverseIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            return ts[--size];
        }

        @Override
        public void remove() {

        }
    }
}
