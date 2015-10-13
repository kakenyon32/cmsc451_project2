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
    private ArrayList<Vertex> cycle = new ArrayList<>();
    // private Stack<Vertex> cycle = new Stack<>();
    
    public Problem2(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V, E);
        Euler(G);
    }
    
    private void Euler(Graph G) {
        // must have at least one edge in order to contain a Euler circuit
        if (G.V.isEmpty()) {
            System.out.println("No vertices, returning");
            cycle = null;
            return;
        }
        
        // All vertices must have an even degree of adjacent vertices
        // *Note: a Eulerian path can exist even if this condition is true
        for (Vertex v : G.V) {
            if (G.adj.get(v).size() % 2 != 0) {
                System.out.println("Not all vertices have even edge sizes");
                cycle = null;
                return;
            }
        }
        
        // start the stack with any non-isolated vertex in G
        Vertex s = nonIsolatedVertex(G);
        if (s == null) {
            cycle = null;
            return;
        }
        
        Stack<Vertex> stack = new Stack<>();
        stack.push(s);
        cycle = new ArrayList<>();
        
        // search through the edges in a Depth-First Search style
        while (!stack.isEmpty()) {
            Vertex u = stack.pop();
            for (Edge e : G.adj.get(u)) {
                if (!e.isVisited()) {
                    e.visit(); // visit the unvisited edge
                    Vertex v = e.get_v(); // get where u points to
                    G.adj.get(v).stream().filter((w) -> (w.get_v() == u)).forEach((w) -> {
                        w.visit(); // ensure that we visit each edge only once
                    });
                    stack.push(v);
                    break;
                }
            }
            // add u to the cycle path
            cycle.add(u);
        }
        
        // we did not get a complete cycle unless it begins and ends 
        // on the same Vertex
        if (cycle.get(0) != cycle.get(cycle.size() - 1)) {
            System.out.println("Does not begin and end on the same Vertex");
            cycle = null;
            return;
        } 
        
        // verify that every edge in the graph has been visited
        G.E.stream().forEach((e) -> {
            if (!e.isVisited()) cycle = null;
        });
    }   
    
    /**
     * @param G takes in a Graph
     * @return a non-isolated Vertex in G or null if no such Vertex exists
     */
    private static Vertex nonIsolatedVertex(Graph G) {
        for (Vertex v : G.V) if (G.adj.get(v).size() > 0) return v;
        return null;
    }
    
    /** @return the list sequence of vertices in order for Euler circuit 
                or null if no such sequence exists
     */
    public ArrayList<Vertex> getEuler() { return cycle; }
    //public LinkedList<Vertex> getEulerList() { return euler; }
    
    /** @return true if circuit exists, otherwise false */
    public boolean EulerCircuit() { return cycle != null; }
}
