/*
 * File:     Test_Driver.java
 * Author:   Kent A Kenyon
 * Date:     October 11, 2015
 * Purpose:  For Problem 3 -> Write a depth-first search algorithm to 
 *           determine if an undirected graph has a cycle
 */
package Graph_Tests;
import Graph_Tests.Graphs.*;
import java.util.*;

/**
 *
 * @author kakenyon32
 */
public class Problem3 {
    // The graph on which to perform the analysis
    public final Graph G;
    private int time;
    private boolean cycle = false;
    
    public Problem3(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V,E);
        DFS(G);
    }
    
    /**
     * Runs a Depth-First Search on G
     * @param G the graph on which to do the DFS
     * Sets the Graph's containCycle boolean to true if a cycle is present
     */
    public final void DFS(Graph G) {
        G.V.stream().forEach((u) -> {
            u.setColor("WHITE");
            u.setParent(null);
        });
        time = 0;
        G.V.stream().forEach((u) -> {
            if (u.getColor().equals("WHITE")) {
                DFS_VISIT(u);
            }
        });
        
        this.G.setCycle(cycle);
    }
    
    /**
     * The visit function for each vertex in a DFS
     * @param u the Vertex to be visited
     */
    public void DFS_VISIT(Vertex u) {
        u.setColor("GRAY");
        if (!G.adj.get(u).isEmpty()) {
            G.adj.get(u).stream().forEach((e)  -> {
                switch (e.get_v().getColor()) {
                    case "WHITE":
                        e.get_v().setParent(u);
                        DFS_VISIT(e.get_v());
                        break;
                    case "GRAY":
                        // if v does not have parent u and has been discovered,
                        // but not finished then it is a back edge.
                        if (u.getParent() != e.get_v()) cycle = true;
                        break;
                }
            });
        }
        u.setColor("BLACK");
    }
}
