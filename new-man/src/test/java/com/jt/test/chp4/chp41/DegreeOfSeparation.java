package com.jt.test.chp4.chp41;

/**
 * since 2016/12/7.
 */
public class DegreeOfSeparation {

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\project\\a\\algs-student\\algs4-data\\movies.txt";
        String delm = "/";
        SymbolGraph symbolGraph = new SymbolGraph(fileName, delm);

        String source = "Jayne, Billy";
        String dest = "Asai, Hisayo";
        if (!symbolGraph.contains(source)) {
            System.out.println("not in database");
            return;
        }


        int s = symbolGraph.index(source);
        BreadthFirstPaths paths = new BreadthFirstPaths(symbolGraph.G(), s);

        if (!symbolGraph.contains(dest)) {
            System.out.println("not in database");
            return;
        }

        int d = symbolGraph.index(dest);

        if (paths.hasPathTo(d)) {
            for (int v : paths.pathTo(d)) {
                System.out.println("  " + symbolGraph.name(v));
            }
        } else {
            System.out.println("not connected");
        }
    }
}
