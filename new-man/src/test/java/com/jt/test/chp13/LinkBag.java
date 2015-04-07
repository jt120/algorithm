package com.jt.test.chp13;

import com.jt.test.api.Bag;

import java.util.Iterator;

/**
 * since 2015/4/7.
 */
public class LinkBag<T> implements Bag<T>, Iterable<T> {
    @Override
    public void add(T t) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
