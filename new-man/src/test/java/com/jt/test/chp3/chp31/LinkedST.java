package com.jt.test.chp3.chp31;

/**
 * since 2016/5/20.
 */
public class LinkedST<K extends Comparable<K>,V> implements ST<K,V> {


    Node first;

    class Node {
        K k;
        V v;
        Node next;

        Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    @Override
    public void put(K k, V v) {
        for (Node n = first; n != null; n = n.next) {
            if (k.equals(n.k)) {
                n.v = v;
                return;
            }
        }
        first = new Node(k, v, first);
    }

    @Override
    public V get(K k) {
        for (Node n = first; n != null; n = n.next) {
            if (k.equals(n.k)) {
                return n.v;
            }
        }
        return null;
    }

    @Override
    public void delete(K v) {

    }

    @Override
    public boolean contain(K k) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        ST<Integer, String> st = new LinkedST<Integer, String>();
        st.put(1, "hello");
        st.put(2, "st");
        st.put(3, "go");
        System.out.println(st.get(1));
        System.out.println(st.get(3));
    }
}
