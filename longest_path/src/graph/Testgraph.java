package graph;
/*
 Test program for graph illustration class
 Introducing Data Structures with Java
 Displays traversal from the same start point by depth & breadth-first
 algorithms
 Finds & displays the path between two points by depth-first search
 together with distance along the path
 Introducing Data Structures with Java
 David Cousins 2009
 */
import java.io.*;
public class Testgraph {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String startpoint, endpoint;
        Graph myGraph = new Graph();
        String start = new String();
        String end = new String();
    //display all graph data stored including adjacency table
        myGraph.displayall();
        System.out.println();
    // perform depth-first traversalfrom a point
        myGraph.traverseDepthFirst("Much Snoring");
        System.out.println();
    //  perform breadth-first traversal from same point
        myGraph.traverseBreadthFirst("Much Snoring");
                // find path & distance between two points
        System.out.println();
        System.out.println("Search for a path between two points");
        System.out.print("Starting point: ");
        startpoint = in.readLine();
        System.out.print("Destination: ");
        endpoint = in.readLine();
        myGraph.depthSearch(startpoint, endpoint);
    }
}
