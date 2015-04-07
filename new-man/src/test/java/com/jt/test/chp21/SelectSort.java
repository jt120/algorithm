package com.jt.test.chp21;

/**
 * since 2015/4/7.
 */
public class SelectSort extends Sort {

    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if(less(a[j],a[min])) min = j;
            }
            exch(a, i, min);

        }
    }
}
