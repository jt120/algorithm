package com.jt.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * since 2016/10/19.
 */
public class Merge {

    public static void sort(Comparable[] data) {
        Comparable[] datax = new Comparable[data.length];
        sort(data, datax, 0, data.length - 1);
    }

    public static void sortBU(Comparable[] data) {
        int size = data.length;
        Comparable[] datax = new Comparable[size];
        //System.out.println("start:" + Arrays.toString(data));
        //sub array
        //sub array index
        for (int sz = 1; sz < size; sz = sz + sz) {
            for (int i = 0; i < size - sz; i += sz + sz) {
                int lo = i;
                int mid = i + sz - 1;
                int hi = Math.min(i + sz + sz - 1, size - 1);
                merge(data, datax, lo, mid, hi);
                //System.out.println("merge:" + sz + ":" + i + ":" + Arrays.toString(data));
            }
        }
    }


    public static void merge(Comparable[] data, Comparable[] datax, int lo, int mid, int hi) {
        //System.out.println("merge lo:" + lo + " hi:" + hi+" mid:"+mid);

        for (int k = lo; k <= hi; k++) {
            datax[k] = data[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) data[k] = datax[j++];
            else if (j > hi) data[k] = datax[i++];
            else if (less(datax[j], datax[i])) data[k] = datax[j++];
            else data[k] = datax[i++];
        }
    }

    public static void sort(Comparable[] data, Comparable[] datax, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(data, datax, lo, mid);
        sort(data, datax, mid + 1, hi);
        merge(data, datax, lo, mid, hi);

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] data, int i, int min) {
        Comparable tmp = data[i];
        data[i] = data[min];
        data[min] = tmp;
    }


    public static boolean isSort(Comparable[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (less(data[i + 1], data[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int N = 100;
        Integer[] datas = new Integer[N];
        for (int i = 0; i < N; i++) {
            datas[i] = random.nextInt(100);
        }

        sortBU(datas);

        if (!isSort(datas)) {
            System.err.println("not sort");
        }

        System.out.println(Arrays.toString(datas));
    }

    @Test
    public void test01() throws Exception {
        int size = 10;
        for (int i = 0; i < size; i += 2) {
            System.out.println(i);
        }
    }

    @Test
    public void test02() throws Exception {
        int size = 10;
        for (int i = 1; i < size; i = i * 2) {
            for (int j = 0; j < size; j += 2 * i) {
                System.out.println(i + ":" + j);
            }
        }
    }


    private int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    @Test
    public void test03() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.print(fib(i)+",");
        }
    }
}
