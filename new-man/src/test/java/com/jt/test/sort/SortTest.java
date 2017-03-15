package com.jt.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * since 2016/10/19.
 */
public class SortTest {

    Random random = new Random();

    @Test
    public void test01() throws Exception {
        int N = 1000;
        Integer[] datas = rands(N);
        testTemp(datas, new SortHandler() {
            @Override
            public void sort(Comparable[] data) {
                Select.sort(data);
            }
        });

        testTemp(datas, new SortHandler() {
            @Override
            public void sort(Comparable[] data) {
                Merge.sort(data);
            }
        });


    }

    interface SortHandler {
        void sort(Comparable[] data);
    }

    private void testTemp(Integer[] datas, SortHandler sortHandler) {
        int N = datas.length;
        long all = 0L;
        StopWatch sw = new StopWatch();
        for (int i = 0; i < N; i++) {
            Integer[] copys = Arrays.copyOf(datas, N);
            sw.start();
            sortHandler.sort(copys);
            long cost = sw.cost();
            all += cost;
        }
        System.out.println("cost " + all);
    }

    public Integer[] rands(int N) {
        Integer[] data = new Integer[N];
        for (int i = 0; i < N; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static class Summer {

    }

    private static class StopWatch {
        private long start;

        public void start() {
            start = System.currentTimeMillis();
        }

        public long cost() {
            if (start == 0L) {
                throw new IllegalStateException();
            }
            return System.currentTimeMillis() - start;
        }
    }
}
