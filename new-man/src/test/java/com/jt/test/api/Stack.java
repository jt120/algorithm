package com.jt.test.api;

/**
 * since 2015/4/7.
 */
public interface Stack <T> {

    public void push(T t);

    public T pop();

    public boolean isEmpty();

    public int size();
}
