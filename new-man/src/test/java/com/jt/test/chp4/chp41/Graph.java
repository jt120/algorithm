package com.jt.test.chp4.chp41;

import std.algs.Bag;
import std.libs.In;

/**
 * since 2016/5/25.
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int v) {
        V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();

        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            //System.out.println("read i:" + i + " v:" + v + " w:" + w);
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for (int v = 0; v < G.V(); v++) {
            final int degree = degree(G, v);
            if (degree > maxDegree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

}
