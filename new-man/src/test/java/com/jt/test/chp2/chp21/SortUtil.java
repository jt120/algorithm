package com.jt.test.chp2.chp21;

/**
 * since 2017/3/15.
 */
public class SortUtil {

    public static boolean isSorted(int[] a, boolean up) {
        for (int i = 0; i < a.length - 1; i++) {
            if (up) {
                if (a[i] > a[i + 1]) {
                    return false;
                }
            } else {
                if (a[i] < a[i + 1]) {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isSorted(Comparable[] a, boolean up) {
        for (int i = 0; i < a.length - 1; i++) {
            if (up) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    return false;
                }
            } else {
                if (a[i].compareTo(a[i + 1]) < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
