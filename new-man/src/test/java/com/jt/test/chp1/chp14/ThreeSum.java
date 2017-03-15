package com.jt.test.chp1.chp14;

import std.libs.In;

/**
 * since 2017/3/15.
 */
public class ThreeSum {

    public static int count(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) throws Exception {
        In in = new In("D:\\project\\a\\algs-student\\algs4-data\\1Kints.txt");
        //4K
        //8K
        final int[] ints = in.readAllInts();
        System.out.println(count(ints));
    }

}
