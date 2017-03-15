package com.jt.test.chp2.chp22;

import java.util.Arrays;
import java.util.Random;

/**
 * since 2016/5/24.
 */
public class MergeBU {

    private static Comparable[] aux;

    public static void main(String[] args) throws Exception {
        Random r = new Random();
        Double[] d = new Double[10];
        for (int i = 0; i < 10; i++) {
            d[i] = r.nextDouble();
        }

        sort(d);

        if (!isSorted(d)) {
            System.out.println("not sort " + Arrays.toString(d));
        }

        System.out.println("ret " + Arrays.toString(d));
    }

    public static void sort(Comparable[] a) {

        final int N = a.length;
        aux = new Comparable[N];
        for (int i = 1; i < N; i = i + i) {
            for (int j = 0; j < N - i; j = j + i + i) {
                merge(a, j, j + i - 1, Math.min(j + i + i - 1, N - 1));
            }
        }


    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a, i, i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


}
