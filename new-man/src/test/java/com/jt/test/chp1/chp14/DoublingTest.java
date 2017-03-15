package com.jt.test.chp1.chp14;

import std.algs.Stopwatch;
import std.libs.StdOut;
import std.libs.StdRandom;

/**
 * since 2017/3/15.
 */
public class DoublingTest {

    public static void main(String[] args) throws Exception {
        for (int i = 250; true; i += i) {
            double d = timeTrial(i);
            StdOut.printf("%7d %5.1f\n", i, d);
        }
    }

    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch stop = new Stopwatch();
        ThreeSum.count(a);
        return stop.elapsedTime();
    }
}
