package com.jt.test.chp21;

/**
 * since 2015/4/7.
 */
public class InsertSort extends Sort {

    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j >0&&less(a[j],a[j-1]); j--) {
                exch(a, j, j-1);
            }

        }
    }
}
