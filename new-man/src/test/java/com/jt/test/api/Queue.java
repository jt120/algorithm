package com.jt.test.api;

/**
 * since 2015/4/7.
 */
public interface Queue<T> {
    public void enqueue(T t);

    public T dequeue();

    public int size();

    public boolean isEmpty();
}
