/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph_Tests.Graphs;

/**
 *
 * @author kakenyon32
 */
public class Edge {
    // variables for the Edge definition
    private final Vertex u, v;
    private String classification;
    
    /**
     * Constructor for an Edge
     * @param u Vertex u
     * @param v Vertex v
     * 
     * for the purposes of a directed graph u points to v
     * for the purposes of an undirected graph u and v point to one another
     */
    public Edge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
    }
    
    /** @return the Vertex u */
    public Vertex get_u() { return u; }
    
    /** @return the Vertex v */
    public Vertex get_v() { return v; }
    
    /** @return the set u, v */
    @Override public String toString() {
        return "(" + u + "," + v + ")";
    }
    
    /**
     * Sets the classification of the edge as tree, back, forward, or cross
     * @param classification to be added to the edge
     */
    public void setClassification(String classification) { 
        this.classification = classification; 
    }
    
    /** @return the classification of the edge */
    public String getClassification() {
        return classification;
    }
}
