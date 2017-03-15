package com.jt.test.chp2.chp21;

import org.junit.Test;
import std.libs.StdRandom;
import std.libs.Stopwatch;

/**
 * @author he
 * @since 2015/4/11
 */
public class SortTest {

    private static final String select = "select";
    private static final String insert = "insert";
    private static final String shell = "shell";
    private static final String merge = "merge";
    private static final String quick = "quick";
    private static final String head = "heap";

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int p1, int p2) {
        Comparable tm = a[p1];
        a[p1] = a[p2];
        a[p2] = tm;
    }

    public static double time(String type, Comparable[] cs) {
        Stopwatch stopwatch = new Stopwatch();
        if (select.equals(type)) {
            Select.sort(cs);
        } else if (insert.equals(type)) {
            Insert.sort(cs);
        } else if (shell.equals(type)) {
            Shell.sort(cs);
        }
        return stopwatch.elapsedTime();
    }

    public static boolean isSorted(Comparable[] cs) {
        for (int i = 1; i < cs.length; i++) {
            if (less(cs[i], cs[i - 1])) {
                return false;
            }
        }
        return true;
    }

    static class Select {
        public static void sort(Comparable[] a) {
            int len = a.length;
            for (int i = 0; i < len; i++) {
                int min = i;
                for (int j = i + 1; j < len; j++) {
                    if (less(a[j], a[min])) min = j;
                }
                exch(a, i, min);
            }
        }
    }

    static class Insert {
        public static void sort(Comparable[] a) {
            int len = a.length;
            for (int i = 1; i < len; i++) {
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }

            }
        }
    }

    static class Shell {
        public static void sort(Comparable[] cs) {
            int len = cs.length;
            int h = 1;
            while (h < len / 3) {
                h = 3 * h + 1;
            }
            while (h >= 1) {
                for (int i = h; i < len; i++) {
                    for (int j = i; j >= h && less(cs[j], cs[j - h]); j -= h) {
                        exch(cs, j, j - h);
                    }
                }
                h = h / 3;
            }

        }
    }


    public static void main(String[] args) throws Exception {
        int len = 10000;
        Double[] doubles = new Double[len];

        int times = 100;
        double s1 = test(select, doubles, times);
        double s2 = test(insert, doubles, times);
        double s3 = test(shell, doubles, times);
        System.out.printf("%s is  %.1f times faster than %s\n",insert,  s1 / s2, select);
        System.out.printf("%s is %.1f times faster than %s\n",shell,  s1 / s3, select);


    }

    @Test
    public void test02() throws Exception {

        String s = "he/zhang";
        final String[] split = s.split("/");
        System.out.println(split[1]);
    }

    private static double test(String type, Comparable[] cs, int times) {
        double total = 0.0;
        for (int j = 0; j < times; j++) {
            for (int i = 0; i < cs.length; i++) {
                cs[i] = StdRandom.uniform();
            }
            total += time(type, cs);
            assert isSorted(cs);
        }
        System.out.println(type + " times " + total);
        return total;
    }
}
