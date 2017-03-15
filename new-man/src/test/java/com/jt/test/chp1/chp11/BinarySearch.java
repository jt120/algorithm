package com.jt.test.chp1.chp11;

import std.libs.In;
import std.libs.StdIn;
import std.libs.StdOut;

import java.util.Arrays;

/**
 * since 2017/3/14.
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int rank2(int key, int lo, int hi, int[] a) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank2(key, lo, mid - 1, a);
        else if (key > a[mid]) return rank2(key, mid + 1, hi, a);
        return mid;
    }

    public static int rank20(int key, int[] a) {
        return rank2(key, 0, a.length - 1, a);
    }

    public static void main(String[] args) throws Exception {
        int[] whitelist = new In("D:\\project\\a\\algs-student\\algs4-data\\tinyW.txt").readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            if (rank20(i, whitelist) > 0) {
                StdOut.println(i);
            }
        }
    }
}
