package com.jt.test.chp1.chp15;

import std.libs.In;
import std.libs.Stopwatch;

/**
 * since 2015/4/7.
 */
public class WeiQuickUnionUF implements UF {

    private int count;
    private int[] ids;
    private int[] size;

    public WeiQuickUnionUF(int count) {
        this.count = count;
        ids = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pc = find(p);
        int qc = find(q);
        if (pc == qc) {
            return;
        }
        if (size[pc] < size[qc]) {
            ids[pc] = qc;
            size[qc] += size[pc];
        } else {
            ids[qc] = pc;
            size[pc] += size[qc];
        }
        //ids[pc] = qc;
        //ids[p] = qc;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\books\\algorithm\\a\\algs\\algs4-data\\largeUF.txt";
        In in = new In(fileName);
        int N = in.readInt();
        UF uf = new WeiQuickUnionUF(N);
        Stopwatch stopwatch = new Stopwatch();
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            //System.out.println("p " + p + " q " + q);

        }
        System.out.println("used: " + stopwatch.elapsedTime());
        System.out.println(uf.count());

    }
}
