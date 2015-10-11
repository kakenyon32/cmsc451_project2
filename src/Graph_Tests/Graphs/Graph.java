/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Tests.Graphs;
import java.util.*;

/**
 *
 * @author kakenyon32
 */
public class Graph {
    public HashMap<Vertex, ArrayList<Edge>> adj = new HashMap<>();
    public ArrayList<Vertex> V = new ArrayList<>();
    public ArrayList<Edge> E = new ArrayList<>();
    
    private boolean containsCycle = false;
    
    /**
     * Constructor for the graph
     * @param V the list of Vertices to be added to the Graph
     * @param E the edges in the Graph
     */
    public Graph(ArrayList<Vertex> V, ArrayList<Edge> E) {
        this.V.addAll(V);
        this.E.addAll(E);
        this.V.stream().forEach((v) -> {
            adj.put(v, new ArrayList<>());
        });
        
        this.E.stream().forEach((e) -> {
            adj.get(e.get_u()).add(e);
        });
    }
    
    /** @param value - sets the value for whether a cycle exists in the graph */
    public void setCycle(boolean value) { containsCycle = value; }
    
    /** @return whether the graph contains a cycle */
    public boolean getCycle() { return containsCycle; }
}
