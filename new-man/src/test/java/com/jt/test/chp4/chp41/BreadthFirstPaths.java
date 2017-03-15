package com.jt.test.chp4.chp41;

import std.algs.Queue;
import std.algs.Stack;

/**
 * since 2016/12/7.
 */
public class BreadthFirstPaths {

    private final int s;
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph G, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            for (int w : G.adj(x)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.enqueue(w);
                    edgeTo[w] = x;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
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
