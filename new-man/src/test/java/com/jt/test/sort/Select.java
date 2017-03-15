package com.jt.test.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * since 2016/10/19.
 */
public class Select {

    public static void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i+1; j < data.length; j++) {
                if (less(data, min, j)) {
                    min = j;
                }
            }
            exch(data, i, min);

        }
    }

    private static boolean less(Comparable[] data, int min, int j) {
        return data[min].compareTo(data[j]) > 0;
    }

    private static void exch(Comparable[] data, int i, int min) {
        Comparable tmp = data[i];
        data[i] = data[min];
        data[min] = tmp;
    }


    public static boolean isSort(Comparable[] data) {
        for (int i = 0; i < data.length-1; i++) {
            if (less(data, i, i + 1)) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Integer[] datas = new Integer[10];
        for (int i = 0; i < 10; i++) {
            datas[i] = random.nextInt(100);
        }

        sort(datas);

        if (!isSort(datas)) {
            System.err.println("not sort");
        }

        System.out.println(Arrays.toString(datas));
    }
}
