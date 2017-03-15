package com.jt.test.chp3.chp31;

/**
 * since 2016/5/20.
 */
public interface ST<K extends Comparable<K>, V> {

    void put(K k, V v);

    V get(K v);

    void delete(K v);

    boolean contain(K k);

    boolean isEmpty();

    int size();


}
