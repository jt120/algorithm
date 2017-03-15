package com.jt.test.chp4.chp41;

import org.junit.Test;
import std.libs.In;

/**
 * since 2016/5/25.
 */
public class TestSearch {

    public static void main(String[] args) throws Exception {
        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyG.txt"));
        int s = 0;
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(g, s);
        for (int v = 0; v < g.V(); v++) {
            if (depthFirstSearch.marked(v)) System.out.print(v + " ");
        }
        System.out.println();

        if (depthFirstSearch.count() != g.V()) {
            System.out.print("NOT ");
        }
        System.out.println("Connect");
    }

    @Test
    public void test01() throws Exception {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setName("zhang");

        User u2 = new User[]{user}.clone()[0];
        System.out.println(u2);
        u2.setName("li");
        System.out.println("user " + user);
    }

    class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("User{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Test
    public void testDepthPath() throws Exception {
        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyCG.txt"));
        int s = 0;
        DepthFirstPaths path = new DepthFirstPaths(g, s);
        for (int v = 0; v < g.V(); v++) {
            System.out.print(s + " to " + v + ":");
            if (path.hasPathTo(v)) {
                for (int x : path.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print(" - " + x);
                    }
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testBreadthPath() throws Exception {
        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyCG.txt"));
        int s = 0;
        BreadthFirstPaths path = new BreadthFirstPaths(g, s);
        for (int v = 0; v < g.V(); v++) {
            System.out.print(s+" to " + v + ":");
            if (path.hasPathTo(v)) {
                for (int x : path.pathTo(v)) {
                    if (x == s) {
                        System.out.print(x);
                    } else {
                        System.out.print(" - " + x);
                    }
                }
            }
            System.out.println();
        }
    }

    @Test
    public void testCC() throws Exception {

        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyG.txt"));
        CC cc = new CC(g);
        System.out.println(cc.count());
    }

    @Test
    public void testCycle() throws Exception {
        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyG.txt"));
        Cycle cycle = new Cycle(g);
        System.out.println(cycle.hasCycle());
    }


    @Test
    public void testIsTwoColor() throws Exception {
        Graph g = new Graph(new In("D:\\project\\a\\algs-student\\algs4-data\\tinyG.txt"));
        TwoColor cycle = new TwoColor(g);
        System.out.println(cycle.isBipaartite());
    }

    @Test
    public void testSymbol() throws Exception {
        String fileName = "D:\\project\\a\\algs-student\\algs4-data\\routes.txt";
        String delim = " ";
        SymbolGraph symbolGraph = new SymbolGraph(fileName, delim);

        Graph g = symbolGraph.G();
        String input = "ORD";
        System.out.println(input);
        for (int w : g.adj(symbolGraph.index(input))) {
            System.out.println("   " + symbolGraph.name(w));
        }

    }

    @Test
    public void testSymbol2() throws Exception {
        String fileName = "D:\\project\\a\\algs-student\\algs4-data\\movies.txt";
        String delim = "/";
        SymbolGraph symbolGraph = new SymbolGraph(fileName, delim);

        Graph g = symbolGraph.G();
        String input = "Jayne, Billy";
        System.out.println(input);
        for (int w : g.adj(symbolGraph.index(input))) {
            System.out.println("   " + symbolGraph.name(w));
        }

    }
}
