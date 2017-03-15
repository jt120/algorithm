package com.jt.test.chp2.chp21;

import std.libs.StdRandom;

import java.util.Arrays;

/**
 * since 2016/5/5.
 */
public class InsertSort {

    /**

     +
     ++
     +++
     ++++
     +++++

     */
    public static void sort(Comparable[] c) {
        for (int i = 1; i < c.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(c[j], c[j - 1])) {
                    exch(c, j, j - 1);
                }
            }
        }
    }

      public static void print(Comparable[] c) {
        for (int i = 1; i < c.length; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print("+");
            }
            System.out.println();
        }
    }


    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] c, int i, int j) {
        Comparable tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static boolean isSort(Comparable[] c) {
        for (int i = 1; i < c.length; i++) {
            if (less(c[i], c[i - 1])) return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        int n = 10;
        Double[] d = new Double[n];
        for (int i = 0; i < n; i++) {
            d[i] = StdRandom.uniform();
        }

        sort(d);

        if (!isSort(d)) {
            System.out.println("not sort");

        }
        System.out.println("ret " + Arrays.toString(d));
        print(d);
    }
}
