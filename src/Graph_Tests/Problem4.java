/*
 * File:     Test_Driver.java
 * Author:   Kent A Kenyon
 * Date:     October 11, 2015
 * Purpose:  For Problem 4 -> Write a breadth-first search algorithm to 
 *           determine if a directed graph has a cycle
 */
package Graph_Tests;
import Graph_Tests.Graphs.*;
import java.util.*;

/**
 *
 * @author kakenyon32
 */
public class Problem4 {
    // The graph on which to perform the analysis
    public final Graph G;
    private Queue<Vertex> Q = new LinkedList<>();
    private boolean cycle = false;
    
    public Problem4(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V,E);
        BFS(G, V.get(0));
    }
    
    private void BFS(Graph G, Vertex start) {
        G.V.stream().forEach((v) -> {
            v.setColor("WHITE");
            v.setDiscovery(0);
            v.setParent(null);
        });
        start.setColor("GRAY");
        Q.add(start);
        while (!Q.isEmpty()) {
            if (!G.adj.get(Q.peek()).isEmpty()) {
                G.adj.get(Q.peek()).stream().forEach((e) -> {
                    switch (e.get_v().getColor()) {
                        case "WHITE":
                            e.get_v().setColor("GRAY");
                            e.get_v().setDiscovery(Q.peek().getDiscovery() + 1);
                            e.get_v().setParent(Q.peek());
                            Q.add(e.get_v());
                            break;
                        case "BLACK": // if this case is true, then there is a cycle
                            cycle = true;
                            break;
                    }
                });
            }
            Q.peek().setColor("BLACK");
            Q.remove();
        }
    }
    
    /** @return whether a cycle exists in the BFS */
    public boolean getCycle() { return cycle; }
}
