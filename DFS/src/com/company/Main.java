package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        System.out.println(graph.getNumberOfVertices());
        System.out.println(Arrays.toString(graph.getVertices()));

        graph.insertVertex(new Node(0));
        graph.insertVertex(new Node(1));
        graph.insertVertex(new Node(2));
        graph.insertVertex(new Node(3));

        graph.insertEdge(0, 1, 8);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 3, 3);
        graph.insertEdge(1, 2, 7);

        System.out.println(graph.getNumberOfVertices());
        System.out.println(Arrays.toString(graph.getVertices()));

        System.out.println(Arrays.toString(graph.getAdjacentVertices(0)));
        System.out.println(graph);


        DFS dfs = new DFS(8);
        dfs.insertVertex(new Node("A"));
        dfs.insertVertex(new Node("B"));
        dfs.insertVertex(new Node("C"));
        dfs.insertVertex(new Node("D"));
        dfs.insertVertex(new Node("E"));
        dfs.insertVertex(new Node("F"));
        dfs.insertVertex(new Node("G"));
        dfs.insertVertex(new Node("H"));

        dfs.insertEdge(0, 1, 8);
        dfs.insertEdge(0, 2, 1);
        dfs.insertEdge(0, 3, 3);
        //dfs.insertEdge(1, 2, 7);
        dfs.insertEdge(4, 5, 2);
        dfs.insertEdge(6, 7, 7);

        System.out.println(dfs.isConnected());
        System.out.println(dfs.isCyclic());
        dfs.printComponents();
    }
}
