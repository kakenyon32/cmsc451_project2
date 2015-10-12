/*
 * File:     Test_Driver.java
 * Author:   Kent A Kenyon
 * Date:     October 11, 2015
 * Purpose:  For Problem 1 -> Write an algorithm to classify the edges of a 
 *           directed graph G into the four categories:
 *              - tree edge
 *              - back edge
 *              - forward edge
 *              - cross edge
 */
package Graph_Tests;
import java.util.*;
import Graph_Tests.Graphs.*;

/**
 *
 * @author kakenyon32
 */
public class Problem1 {
    // The graph on which to perform the analysis
    public final Graph G;
    private int time;
    
    /**
     * The constructor
     * @param V the vertices for the directed graph
     * @param E the edges for the directed graph
     */
    public Problem1(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V, E);
        DFS(G);
    }
    
    /**
     * Runs a Depth-First Search on G
     * @param G the graph on which to do the DFS
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
    }
    
    /**
     * The visit function for each vertex in a DFS
     * @param u the Vertex to be visited
     */
    public void DFS_VISIT(Vertex u) {
        u.setColor("GRAY");
        u.setDiscovery(time);
        time++;
        
        if (!G.adj.get(u).isEmpty()) {
            G.adj.get(u).stream().forEach((e)  -> {
                switch (e.get_v().getColor()) {
                    case "WHITE":
                        // if v has not yet been discovered, then (u,v) is a Tree edge
                        e.setClassification("TREE");
                        e.get_v().setParent(u);
                        DFS_VISIT(e.get_v());
                        break;
                    case "GRAY":
                        // if v has been discovered, but not finished then it is a back edge.
                        e.setClassification("BACK");
                        break;
                    case "BLACK":
                        // get a list of ancestors
                        ArrayList<Vertex> list = Traverse(e.get_v());
                        // if u is an ancestor of v, then (u,v) is a forward edge
                        if (list.contains(u)) e.setClassification("FORWARD");
                        // if u is not an ancestor of v , then (u,v) is a cross edge
                        else e.setClassification("CROSS");
                        break;
                }
            });
        }
        u.setColor("BLACK");
        u.setFinish(time);
        time++;
    }
    
    /**
     * Traverses the ancestor path of a given Vertex
     * @param u the Vertex to be traced
     * @return a list of ancestors to a root Vertex
     */
    public ArrayList<Vertex> Traverse(Vertex u) {
        ArrayList<Vertex> ancestors = new ArrayList<>();
        while (u.getParent() != null) {
            ancestors.add(u.getParent());
            u = u.getParent();
        }
        return ancestors;
    }
    
}
