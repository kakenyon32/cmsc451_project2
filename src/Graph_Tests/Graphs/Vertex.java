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
public class Vertex {
    // holds the vertex veriable
    private final String vertex;
    private Vertex parent;
    private String color;
    private int discovery, finish;
    
    /**
     * Constructor for the Node
     * @param v the vertex to be saved
     */
    public Vertex(String v) { 
        vertex = v;
    }
    
    /** @param v the parent vertex */
    public void setParent(Vertex v) { this.parent = v; }
    
    /** @param color for the vertex */
    public void setColor(String color) { this.color = color; }
    
    /** @param time the discovery time of the vertex */
    public void setDiscovery(int time) { discovery = time; }
    
    /** @param time the finish time of the vertex */
    public void setFinish(int time) { finish = time; }
    
    /** @return the vertex name */
    @Override public String toString() { return vertex; }
    
    /** @return the parent vertex */
    public Vertex getParent() { return parent; }
    
    /** @return the vertex color */
    public String getColor() { return color; }
    
    /** @return the discovery time of the vertex */
    public int getDiscovery() { return discovery; }
    
    /** @return the finish time of the vertex */
    public int getFinish() { return finish; }
}
