package com.jt.test.chp2.chp22;

import std.libs.StdRandom;

import java.util.Arrays;

/**
 * since 2016/5/10.
 */
public class MergeSort {

    static Comparable[] aux;

    public static void sort(Comparable[] c) {
        aux = new Comparable[c.length];
        sort(c, 0, c.length - 1);
    }

    public static void main(String[] args) throws Exception {
        Double[] d = new Double[10];
        for (int i = 0; i < 10; i++) {
            d[i] = StdRandom.uniform();
        }

        sort(d);

        if (!isSorted(d)) {
            System.out.println("not sort ");
        }

        System.out.println("ret " + Arrays.toString(d));

    }

    public static void sort(Comparable[] c, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(c, lo, mid);
        sort(c, mid + 1, hi);
        merge(c, lo, mid, hi);
    }

    private static void merge(Comparable[] c, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            aux[i] = c[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) c[k] = aux[j++];
            else if (j > hi) c[k] = aux[i++];
            else if (less(aux[j], aux[i])) c[k] = aux[j++];
            else c[k] = aux[i++];
        }
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

}
