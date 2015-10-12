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
        ArrayList<Edge> possible = new ArrayList<>();
        while (!Q.isEmpty()) {
            if (!G.adj.get(Q.peek()).isEmpty()) {
                G.adj.get(Q.peek()).stream().forEach((e) -> {
                    if (e.get_v().getColor().equals("WHITE")) {
                        e.get_v().setColor("GRAY");
                        e.get_v().setDiscovery(Q.peek().getDiscovery() + 1);
                        e.get_v().setParent(Q.peek());
                        Q.add(e.get_v());
                    } else {
                        // because this is a directed graph, if "v" has been
                        // visited previously, and is at a depth less than the
                        // current "u", then there may be a cycle.
                        if (e.get_v().getDiscovery() < Q.peek().getDiscovery())
                            possible.add(e);
                    }
                });
            }
            Q.peek().setColor("BLACK");
            Q.remove();
        }
        
        // now that the BFS is complete, test "possible" candidates for 
        // common ancestory in reverse order.
        possible.stream().forEach((e) -> {
            ArrayList<Vertex> list = Traverse(e.get_u());
            if (list.contains(e.get_v())) cycle = true;
            else G.adj.get(e.get_v()).stream().forEach((e2) -> {
                    if (list.contains(e2.get_v())) cycle = true;
                });
        });
    }
    
    /** @return whether a cycle exists in the BFS */
    public boolean getCycle() { return cycle; }
    
    /**
     * Traverses the ancestor path of a given Vertex
     * @param u the Vertex to be traced
     * @return a list of ancestors to a root Vertex
     */
    private ArrayList<Vertex> Traverse(Vertex u) {
        ArrayList<Vertex> ancestors = new ArrayList<>();
        while (u.getParent() != null) {
            ancestors.add(u.getParent());
            u = u.getParent();
        }
        return ancestors;
    }
}
