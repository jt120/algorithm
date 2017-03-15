package com.jt.test.chp4.chp41;

import std.algs.Stack;

/**
 * since 2016/12/7.
 */
public class DepthFirstPaths {

    private final int s;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        dsf(G, s);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public void dsf(Graph G, int v) {
        this.marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dsf(G, w);

            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }
}
