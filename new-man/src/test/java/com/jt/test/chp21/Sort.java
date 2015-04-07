package com.jt.test.chp21;

/**
 * since 2015/4/7.
 */
public abstract class Sort {

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void exch(Comparable[] a, int p1, int p2) {
        Comparable tm = a[p1];
        a[p1] = a[p2];
        a[p2] = tm;
    }

}
