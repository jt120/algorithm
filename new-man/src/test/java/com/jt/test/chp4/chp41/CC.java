package com.jt.test.chp4.chp41;

/**
 * since 2016/12/7.
 */
public class CC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph g) {
        this.marked = new boolean[g.V()];
        this.id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

}
