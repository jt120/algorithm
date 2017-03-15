package com.jt.test.chp3.chp31;

/**
 * since 2017/1/17.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }

    private void resize(int max) {
        Key[] nk = (Key[]) new Comparable[max];
        for (int i = 0; i < N; i++) {
            nk[i] = keys[i];
        }
        keys = nk;


        Value[] nv = (Value[]) new Comparable[max];
        for (int i = 0; i < N; i++) {
            nv[i] = values[i];
        }
        values = nv;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
        if (keys.length <= N) {
            resize(2 * N);
        }
    }




    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int c = key.compareTo(keys[mid]);
            if (c < 0) {
                hi = mid - 1;
            } else if (c > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchST<String, Integer> m = new BinarySearchST<>(10);
        for (int i = 0; i < 100; i++) {
            m.put(i + "", i);
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(m.get(i+""));
        }
    }
}
