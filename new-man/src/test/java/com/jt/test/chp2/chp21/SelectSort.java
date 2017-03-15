package com.jt.test.chp2.chp21;

import java.util.Arrays;

/**
 * since 2016/5/5.
 */
public class SelectSort {

    /**
     * +++++
     * ++++
     * +++
     * ++
     * +
     */
    public static void sortSelect(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static void sort2(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j],a[j-1])) exch(a, j, j-1);
            }
        }
    }


    public static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    public static void exch(Comparable[] c, int i, int j) {
        Comparable tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }


    public static void main(String[] args) throws Exception {
        final Integer[] integers = ArrayBuilder.integers(50);

        sort2(integers);

        if (!SortUtil.isSorted(integers, true)) {
            System.out.println("not sort");

        }
        System.out.println("ret " + Arrays.toString(integers));
    }
}
