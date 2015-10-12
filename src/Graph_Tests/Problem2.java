/*
 * File:     Test_Driver.java
 * Author:   Kent A Kenyon
 * Date:     October 11, 2015
 * Purpose:  For Problem 2 -> Give an algorithm that finds an Euler circuit 
 *           in a graph, or tells that the graph doesn’t have one.
 */
package Graph_Tests;
import Graph_Tests.Graphs.*;
import java.util.*;

/**
 *
 * @author kakenyon32
 */
public class Problem2 {
    // The graph on which to perform the analysis
    public final Graph G;
    private LinkedList<Vertex> euler = new LinkedList<>();
    private Vertex currentVertex;
    
    public Problem2(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V, E);
        findEuler(G);
    }
    
    private void findEuler(Graph G) {
        currentVertex = G.V.get(0);
        makePath(currentVertex);
    }
    
    private void makePath(Vertex v) {
        euler.add(v);
        while (G.adj.size() > 0) {
            if (!G.adj.get(v).isEmpty()) {
                currentVertex = G.adj.get(v).remove(0).get_v();
                makePath(v);
            }
        }
    }
    
    public LinkedList<Vertex> getEuler() { return euler; }
}
