package com.jt.test.api;

/**
 * since 2015/4/7.
 */
public interface Bag<T> {

    public void add(T t);

    public int size();

    public boolean isEmpty();
}
