/*
 * File:     Test_Driver.java
 * Author:   Kent A Kenyon
 * Date:     October 11, 2015
 * Purpose:  Perform Benchmark analysis of the four problems provided.
 */
package Graph_Tests;
import java.util.*;
import Graph_Tests.Graphs.*;

/**
 * 
 * @author kakenyon32
 */
public class Test_Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(
                "++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                + "+++++    Kent Kenyon - CMSC451: PROJECT 2    +++++\n"
                + "++++++++++++++++++++++++++++++++++++++++++++++++++\n"
        );
        
        
        /* PROBLEM 1 OUTPUT */
        System.out.println(
                "Problem 1:\n"
                + "\tWrite an algorithm to classify the edges \n"
                + "\tof a directed graph G into the four\n"
                + "\tcategories: tree edge, back edge, forward\n"
                + "\tedge and cross edge.\n\n"
        );
        /* PROBLEM 1 REQUIRED INPUT */
        //                        0    1    2    3    4    5    6
        String[] p1_req_verts = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] p1_req_edges = {
            {0, 3}, {0, 5}, {1, 0}, {2, 0}, {2, 1},
            {2, 3}, {2, 4}, {2, 5}, {3, 1}, {3, 6},
            {4, 6}, {5, 0}, {6, 4}
        };
        // SET THE VERTICES
        ArrayList<Vertex> V1_1 = new ArrayList<>();
        for (String v : p1_req_verts) { V1_1.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E1_1 = new ArrayList<>();
        for (int[] e : p1_req_edges) {
            E1_1.add(new Edge(V1_1.get(e[0]), V1_1.get(e[1])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLEM 1 #1
        Problem1 P1_1 = new Problem1(V1_1, E1_1);
        System.out.println("======= EDGE CLASSIFICATION PROBLEM 1 #1 =======");
        P1_1.G.E.stream().forEach((e) -> {
            System.out.println(e.toString() + " => " + e.getClassification());
        });
        System.out.println("\n");
        
        
        /* PROBLEM 1 STUDENT INPUT */
        //                       0    1    2    3    4    5    6    7
        String[] p1_my_verts = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int[][] p1_my_edges = {
            {0, 1}, {0, 2}, {0, 3}, {0, 5}, {1, 3},
            {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5},
            {4, 0}, {6, 1}, {6, 7}, {7, 3}
        };
        // SET THE VERTICES
        ArrayList<Vertex> V1_2 = new ArrayList<>();
        for (String v : p1_my_verts) { V1_2.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E1_2 = new ArrayList<>();
        for (int[] e : p1_my_edges) {
            E1_2.add(new Edge(V1_2.get(e[0]), V1_2.get(e[1])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLEM 1 #2
        Problem1 P1_2 = new Problem1(V1_2, E1_2);
        System.out.println("======= EDGE CLASSIFICATION PROBLEM 1 #2 =======");
        P1_2.G.E.stream().forEach((e) -> {
            System.out.println(e.toString() + " => " + e.getClassification());
        });
        System.out.println("\n");
        
        
        
        /* PROBLEM 2 OUTPUT */
        System.out.println(
                "Problem 2:\n"
                + "\tGive an algorithm that finds a Euler\n"
                + "\tcircuit in a graph, or tells that the\n"
                + "\tgraph does not have one.\n\n"
        );
        System.out.println("\n");
        /* PROBLEM 2 REQUIRED INPUT */
        //                        0    1    2    3    4    5    6    7    8    9
        String[] p2_req_verts = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int[][] p2_req_edges = {
            {0, 1}, {0, 9}, {1, 2}, {2, 3}, {2, 5}, {2, 8}, {3, 4},
            {4, 5}, {5, 6}, {5, 8}, {6, 7}, {7, 8}, {8, 9},
        };
        // SET THE VERTICES
        ArrayList<Vertex> V2_1 = new ArrayList<>();
        for (String v : p2_req_verts) { V2_1.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E2_1 = new ArrayList<>();
        for (int[] e : p2_req_edges) {
            E2_1.add(new Edge(V2_1.get(e[0]), V2_1.get(e[1])));
            E2_1.add(new Edge(V2_1.get(e[1]), V2_1.get(e[0])));
        }
        Problem2 P2_1 = new Problem2(V2_1, E2_1);
        
        
        
        
        
        /* PROBLEM 3 OUTPUT */
        System.out.println(
                "Problem 3:\n"
                + "\tWrite a depth-first search algorithm to\n"
                + "\tdetermine if an undirected graph has a cycle.\n\n"
        );
        
        /* PROBLEM 3 REQUIRED INPUT */
        //                        0    1    2    3    4    5    6
        String[] p3_req_verts = {"1", "2", "3", "4", "5", "6", "7"};
        int[][] p3_req_edges = {
            {0, 1}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, 
            {2, 4}, {3, 4}, {4, 0}, {5, 3}, {5, 6}
        };
        // SET THE VERTICES
        ArrayList<Vertex> V3_1 = new ArrayList<>();
        for (String v : p3_req_verts) { V3_1.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E3_1 = new ArrayList<>();
        for (int[] e : p3_req_edges) {
            E3_1.add(new Edge(V3_1.get(e[0]), V3_1.get(e[1])));
            E3_1.add(new Edge(V3_1.get(e[1]), V3_1.get(e[0])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLEM 3 #1
        Problem3 P3_1 = new Problem3(V3_1, E3_1);
        if (P3_1.G.getCycle()) { 
            System.out.println("The required input contains a cycle.\n"
                    + "Back edges are present."); 
        } else { 
            System.out.println("The required input does not contain a cycle."); 
        }
        System.out.println();
        
        /* PROBLEM 3 STUDENT INPUT */
        //                       0    1    2    3    4    5    6
        String[] p3_my_verts = {"1", "2", "3", "4", "5", "6", "7"};
        int[][] p3_my_edges = {
            {0, 2}, {0, 3}, {1, 6}, {2, 1}, {2, 4}, {3, 5}
        };
        // SET THE VERTICES
        ArrayList<Vertex> V3_2 = new ArrayList<>();
        for (String v : p3_my_verts) { V3_2.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E3_2 = new ArrayList<>();
        for (int[] e : p3_my_edges) {
            E3_2.add(new Edge(V3_2.get(e[0]), V3_2.get(e[1])));
            E3_2.add(new Edge(V3_2.get(e[1]), V3_2.get(e[0])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLME 3 #2
        Problem3 P3_2 = new Problem3(V3_2, E3_2);
        if (P3_2.G.getCycle()) {
            System.out.println("The student input contains a cycle.\n"
                    + "Back edges are present");
        } else {
            System.out.println("The student input does not contain a cycle.");
        }
        System.out.println("\n");
        

        /* PROBLEM 4 OUTPUT */
        System.out.println(
                "Problem 4:\n"
                + "\tWrite a breadth-first search algorithm to \n"
                + "\tdetermine if a directed graph has a cycle.\n"
        );
        
        
        /* PROBLEM 4 REQUIRED INPUT */
        //                        0    1    2    3    4    5    6
        String[] p4_req_verts = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] p4_req_edges = {
            {0, 1}, {0, 2}, {0, 5}, {1, 2}, {1, 3}, 
            {3, 0}, {3, 2}, {4, 2}, {4, 6}, {5, 0}, 
            {5, 2}, {6, 3}, {6, 4}
        };
        // SET THE VERTICES
        ArrayList<Vertex> V4_1 = new ArrayList<>();
        for (String v : p4_req_verts) { V4_1.add(new Vertex(v)); }
        // SET THE EDGES
        ArrayList<Edge> E4_1 = new ArrayList<>();
        for (int[] e : p4_req_edges) {
            E4_1.add(new Edge(V4_1.get(e[0]), V4_1.get(e[1])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLEM 4 #1
        Problem4 P4_1 = new Problem4(V4_1, E4_1);
        if (P4_1.getCycle()) System.out.println("A cycle exists");
        else System.out.println("No cycle exists");
        //
        String[] p4_my_verts = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] p4_my_edges = {
            {0, 1}, {1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 6}, {5, 6}
        };
        ArrayList<Vertex> V4_2 = new ArrayList<>();
        for (String v : p4_my_verts) { V4_2.add(new Vertex(v)); }
        ArrayList<Edge> E4_2 = new ArrayList<>();
        for (int[] e : p4_my_edges) {
            E4_2.add(new Edge(V4_2.get(e[0]), V4_2.get(e[1])));
        }
        // SET THE PROBLEM UP AND OUTPUT SOLUTION FOR PROBLEM 4 #2
        Problem4 P4_2 = new Problem4(V4_2, E4_2);
        if (P4_2.getCycle()) System.out.println("A cycle exists");
        else System.out.println("No cycle exists");
    }
    
}
