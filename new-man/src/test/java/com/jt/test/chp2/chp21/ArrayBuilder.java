package com.jt.test.chp2.chp21;

import java.util.Arrays;
import java.util.Random;

/**
 * since 2017/3/15.
 */
public class ArrayBuilder {

    public static int[] ints(int size) {
        int[] a = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static Integer[] integers(int size) {
        Integer[] a = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(ints(10)));
    }
}
