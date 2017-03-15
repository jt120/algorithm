package com.jt.test.chp1.chp15;

/**
 * since 2015/4/7.
 */
public interface UF {

    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();
}
