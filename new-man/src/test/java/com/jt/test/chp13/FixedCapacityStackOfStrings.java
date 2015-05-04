package com.jt.test.chp13;

/**
 * since 2015/4/8.
 */
public class FixedCapacityStackOfStrings {

    private String[] items;
    private int size;

    public FixedCapacityStackOfStrings(int N) {
        items = new String[N];
    }

    void push(String item) {
        items[size++] = item;
    }

    String pop() {
        String item = items[--size];
        items[size]=null;
        return item;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size==items.length;
    }

    public static void main(String[] args) throws Exception {
        FixedCapacityStackOfStrings fix = new FixedCapacityStackOfStrings(100);
        fix.push("hello");
        fix.push("you");
        fix.pop();
        System.out.println(fix.size());
    }
}
