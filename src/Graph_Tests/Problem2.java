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
    
    public Problem2(ArrayList<Vertex> V, ArrayList<Edge> E) {
        G = new Graph(V, E);
    }
}
