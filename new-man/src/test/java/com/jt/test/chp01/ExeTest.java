package com.jt.test.chp01;

import org.junit.Assert;
import org.junit.Test;
import std.libs.In;
import std.libs.StdOut;
import std.libs.StdRandom;
import std.libs.Stopwatch;

import java.io.File;
import java.util.Arrays;

/**
 * since 2015/4/2.
 */
public class ExeTest {

    @Test
    public void test111() throws Exception {
        int a = (0 + 15) / 2;
        double b = 2.0e-6 * 10000000.1;
        boolean c = true && false || true && true;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void test112() throws Exception {
        double v = (1 + 2.236) / 2;
        double v1 = 1 + 2 + 3 + 4.0;
        boolean b = 4.1 >= 4;
        String s = 1 + 2 + "3";

    }

    @Test
    public void test115() throws Exception {
        double x = 0.5;
        double y = 0.2;
        if (x < 1 && y < 1 && x > 0 && y > 0) {
            System.out.println(true);
        }
    }

    @Test
    public void test116() throws Exception {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @Test
    public void test117() throws Exception {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    @Test
    public void test118() throws Exception {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    @Test
    public void test119() throws Exception {
        int a = 10;
        String s = "";
        // 1010
        for (int i = a; i > 0; i = i / 2) {
            s = (i % 2) + s;
        }
        System.out.println(s);
        Integer.toBinaryString(a);
    }

    @Test
    public void test1111() throws Exception {
        boolean[][] bb = new boolean[4][5];
        bb[1][2] = true;
        bb[0][0] = true;

        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print("  ");
                if (i == 0) {
                    System.out.print(j + 1 + " ");
                }
                if (bb[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int rank2(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        int count = 1;
        while (lo <= hi) {
            count++;
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else {
                System.out.println(count);
                return mid;
            }
        }
        System.out.println(count);
        return -1;
    }

    @Test
    public void testRank() throws Exception {
        File file = new File("D:\\books\\algorithm\\a\\algs\\algs4-data\\tinyW.txt");
        In in = new In(file);
        int[] ints = in.readAllInts();
        // for (int i = 0; i < ints.length; i++) {
        // System.out.println(ints[i]);
        // }

        Arrays.sort(ints);

        In ch = new In(new File("D:\\books\\algorithm\\a\\algs\\algs4-data\\tinyT.txt"));
        int[] ints1 = ch.readAllInts();
        for (int i = 0; i < ints1.length; i++) {
            int rank = rank(ints1[i], ints);
            if (rank > 0) {
                System.out.println(ints1[i]);
            }
        }
    }

    @Test
    public void test1113() throws Exception {
        int[][] aa = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                aa[i][j] = StdRandom.uniform(10);
            }
        }

        printArray(aa);

        int len = aa.length;
        int[][] bb = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                bb[i][j] = aa[j][i];
            }
        }

        printArray(bb);

    }

    // ???
    @Test
    public void test1116() throws Exception {
        String s = exR1(6);
        System.out.println(s);
    }

    @Test
    public void test1118() throws Exception {
        int mystery = mystery(2, 25);
        System.out.println(mystery);
    }

    public static int mystery(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    // Develop a better implementation of F(N) that saves computed values in an array
    @Test
    public void test1119() throws Exception {
        long[] num = new long[100];
        for (int i = 0; i < 100; i++) {
            // StdOut.println(i + " " + F(i));
            StdOut.println(i + " " + F(i, num));
        }
    }

    @Test
    public void test1120() throws Exception {
        // ln(N!)
    }

    @Test
    public void test1122() throws Exception {
        File file = new File("D:\\books\\algorithm\\a\\algs\\algs4-data\\tinyW.txt");
        In in = new In(file);
        int[] ints = in.readAllInts();

        Arrays.sort(ints);

        int rank = rank1(23, ints);
        System.out.println(rank);
    }

    public static int[] readFromFile(String fileName) {
        File file = new File(fileName);
        In in = new In(file);
        int[] ints = in.readAllInts();
        return ints;
    }

    public static int rank1(int key, int[] a) {
        return rank1(key, a, 0, a.length - 1, 1);
    }

    public static int rank1(int key, int[] a, int lo, int hi, int dep) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < dep; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("depth: " + dep + " low: " + lo + " high: " + hi);
        System.out.println(stringBuilder.toString());
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank1(key, a, lo, mid - 1, ++dep);
        } else if (key > a[mid]) {
            return rank1(key, a, mid + 1, hi, ++dep);
        } else {
            return mid;
        }
    }

    @Test
    public void test() throws Exception {
        if (true) {
            System.out.println("a");

        } else if (true) {
            System.out.println("b");

        }
    }

    public static int G(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return G(q, r);
    }

    @Test
    public void test2() throws Exception {
        int g = G(10, 5);
        System.out.println(g);
        System.out.println(G(10, 3));
    }

    @Test
    public void test1139() throws Exception {
        int n = 1000;

        int[] a1 = new int[n];
        int[] a2 = new int[n];

        // System.out.println(Arrays.toString(a1));
        // System.out.println(Arrays.toString(a2));
        RM(10, n, a1, a2);
        RM(100, n, a1, a2);
        RM(1000, n, a1, a2);
        RM(10000, n, a1, a2);

    }

    private void RM(int ci, int n, int[] a1, int[] a2) {
        long sum = 0;
        int count = 0;
        Stopwatch stopwatch = new Stopwatch();
        for (int k = 0; k < ci; k++) {
            for (int i = 0; i < n; i++) {
                a1[i] = StdRandom.uniform(100000, 999999);
                a2[i] = StdRandom.uniform(100000, 999999);
            }
            Arrays.sort(a1);
            Arrays.sort(a2);

            for (int j = 0; j < n; j++) {
                int rank = rank2(a2[j], a1);
                if (rank > 0) {
                    // System.out.println(a2[j]);
                    count++;
                    sum += a2[j];
                }
            }
        }
        System.out.println(ci + "\t" + sum / count + "\t" + stopwatch.elapsedTime());
    }

    public static long F(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long F(int n, long[] res) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long num = res[n];
        if (num != 0) {
            return num;
        } else {
            res[n] = F(n - 1, res) + F(n - 2, res);
            return res[n];
        }
    }

    private void printArray(int[][] aa) {
        int len = aa.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(aa[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("==================");
    }

    public static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }


    @Test
    public void test1138() throws Exception {
        int[] wl = readFromFile("D:\\books\\algorithm\\algs4-data\\largeW.txt");
        int[] tran = readFromFile("D:\\books\\algorithm\\algs4-data\\largeT.txt");
        Stopwatch stopwatch = new Stopwatch();
        Arrays.sort(wl);
        int length = tran.length;
        for (int i = 0; i < length; i++) {
            int search = BinarySearch.search(tran[i], wl);
            if (search > 0) {
                System.out.println(wl[search]);
            }
        }
        System.out.println("used " + stopwatch.elapsedTime());

    }

    @Test
    public void test11382() throws Exception {
        int[] wl = readFromFile("D:\\books\\algorithm\\algs4-data\\largeW.txt");
        int[] tran = readFromFile("D:\\books\\algorithm\\algs4-data\\largeT.txt");
        Stopwatch stopwatch = new Stopwatch();
//        Arrays.sort(wl);
        int length = tran.length;
        for (int i = 0; i < length; i++) {
            int search = BruteSearch.search(tran[i], wl);
            if (search > 0) {
                System.out.println(wl[search]);
            }
        }
        System.out.println("used " + stopwatch.elapsedTime());

    }
}
