package com.jt.test.chp4.chp41;

/**
 * since 2016/5/25.
 */
public class DepthFirstSearch {


    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        dsf(g, s);

    }

    public void dsf(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w : g.adj(v)) {
            if(!marked(w)) dsf(g, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
