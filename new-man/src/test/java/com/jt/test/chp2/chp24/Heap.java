package com.jt.test.chp2.chp24;

/**
 * since 2016/5/17.
 */
public class Heap<T extends Comparable<T>> {

    private T[] c;
    private int N;

    public Heap(int maxN) {
        c = (T[]) new Comparable[maxN+1];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T t) {
        c[++N] = t;
        swim(N);
    }

    public T delMax() {
        T max = c[1];
        exch(1, N--);
        c[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2*k;
            if(j< N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return c[i].compareTo(c[j]) < 0;
    }

    private void exch(int i, int j) {

        T tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>(10);
        for (int i = 0; i < 5; i++) {
            heap.insert(i);
        }

        System.out.println(heap.delMax());
    }


}
