package com.jt.test.chp4.chp41;

import std.algs.ST;
import std.libs.In;

/**
 * since 2016/12/7.
 */
public class SymbolGraph {

    private ST<String,Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            final String[] split = in.readLine().split(sp);
            for (int i = 0; i < split.length; i++) {
                if (!st.contains(split[i])) {
                    st.put(split[i], st.size());
                }
            }
        }

        keys = new String[st.size()];
        for (String name: st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());

        in = new In(stream);
        while (in.hasNextLine()) {
            final String[] split = in.readLine().split(sp);
            int v = st.get(split[0]);
            for (int i = 1; i < split.length; i++) {
                G.addEdge(v, st.get(split[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int index) {
        return keys[index];
    }

    public Graph G() {
        return G;
    }



}
