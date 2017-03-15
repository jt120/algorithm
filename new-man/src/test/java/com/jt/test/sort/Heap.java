package com.jt.test.sort;

/**
 * since 2016/11/1.
 */
public class Heap<Key extends Comparable<Key>> {

    private Key[] keys;
    private int N;

    public Heap(int n) {
        keys = (Key[]) new Object[n + 1];
    }

    public void insert(Key k) {
        keys[++N] = k;
        swim(N);
    }

    public Key delMax() {
        Key max = keys[1];
        exch(1, N--);
        keys[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean less(int i, int j) {
        return false;
    }

    public void exch(int i, int j) {
        Key tmp = keys[i];
        keys[i] = keys[j];
        keys[j] = tmp;

    }

    public void swim(int i) {
        while (i > 1 && less(i / 2, i)) {
            exch(i / 2, i);
            i = i / 2;
        }
    }

    public void sink(int i) {
        while (2*i <= N) {
            int j = 2 * i;
            if (j < N && less(j, j + 1)) j++;
            if (!less(i, j)) {
                break;
            }
            exch(i, j);
            i = j;
        }
    }
}
