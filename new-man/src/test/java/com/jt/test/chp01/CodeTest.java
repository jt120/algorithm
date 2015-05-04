package com.jt.test.chp01;

import org.junit.Test;
import std.libs.StdDraw;
import std.libs.StdRandom;

import java.util.Arrays;

/**
 * @author he
 * @since 2015/4/6
 */
public class CodeTest {

    @Test
    public void test1120() throws Exception {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);

        for (int i = 0; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));

        }
        System.in.read();
    }



    @Test
    public void test1121() throws Exception {
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);

        }
        System.in.read();
    }

    @Test
    public void test1122() throws Exception {
        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);

        }
        System.in.read();
    }

    @Test
    public void test() throws Exception {
        int[] a = new int[100];
        int lo = 0;
        int hi = a.length - 1;
        int key = 12;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(key < a[mid]) hi = mid-1;
            else if (key > a[mid]) lo = mid + 1;
            else key = a[mid];
        }
        key = -1;

    }

    @Test
    public void test02() throws Exception {
        int[] a = new int[100];
        int len = a.length;
        int key = 12;
        for (int i = 0; i < len; i++) {
            if (key == a[i]) {
                key = i;
            }

        }
        key = -1;


    }
}
