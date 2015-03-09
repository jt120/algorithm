/*************************************************************************
 *  Compilation:  javac SmallWorld.java
 *  Dependencies: Graph.java PathFinder.java
 *
 *************************************************************************/

public class SmallWorld {

    public static double avgDegree(Graph G) {
        return (double) 2 * G.E() / G.V();
    }

    public static double avgDistance(Graph G) {
        int totalEdges = 0; 
        int totalPairs = G.V() * (G.V() - 1);

        int count = 0;
        for (String v : G.vertices()) {
            if (count > 0 && count % 100 == 0) StdOut.println(count);
            count++;
            PathFinder finder = new PathFinder(G, v);
            for (String w : G.vertices()) {
                if (finder.hasPathTo(v)) {
                    totalEdges += finder.distanceTo(w);
                }
            }
        }
        return (double) totalEdges / totalPairs;
    }

    // return maximum degree of any vertex
    public static int maxDegree(Graph G) {
        int max = 0;
        for (String v : G.vertices()) {
            if (G.degree(v) > max)
                max = G.degree(v);
        }
        return max;
    }


    public static double clusterCoeff(Graph G) {
        int nonEdges = 0;
//        int edges    = 4 * G.E();
        int edges    = 2 * G.E();

        // neighborhood 1
        int count = 0;
        for (String v : G.vertices()) {
            if (count > 0 && count % 100 == 0) StdOut.println(count);
            count++;
            for (String w : G.adjacentTo(v)) {
                for (String x : G.adjacentTo(w)) {
                    if (G.hasEdge(v, x)) edges++;
                    //else if (!w.equals(x)) nonEdges++;
                    else nonEdges++;
                }
            }
        } 
        return (double) edges / (edges + nonEdges);
    } 



    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        In in = new In(filename);
        Graph G = GraphGenerator.read(in, delimiter);

        StdOut.printf("number of vertices  = %7d\n", G.V());
        StdOut.printf("number of edges     = %7d\n", G.E());
        StdOut.printf("average degree      = %7.3f\n", avgDegree(G));
        StdOut.printf("maximum degree      = %7d\n",   maxDegree(G));
        StdOut.printf("cluster coefficient = %7.3f\n", clusterCoeff(G));
        StdOut.printf("average distance    = %7.3f\n", avgDistance(G));

    }

}
