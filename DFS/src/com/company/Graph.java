package com.company;

import java.util.*;

public class Graph<T> {
    protected int numNodes;
    protected int maxVertices;
    protected Node<T>[] vertices;
    protected List<Edge> adjList;

    // Creates a new graph for a maximum of maxVertices nodes.
    public Graph(int maxVertices) {
        this.numNodes = 0;
        this.maxVertices = maxVertices;
        this.vertices = new Node[maxVertices];
        this.adjList = new ArrayList<>();
    }

    // Returns the number of inserted nodes.
    public int getNumberOfVertices() {
        return numNodes;
    }

    // Returns an array of length getNumVertices() with all inserted nodes.
    public MyVertex[] getVertices() {
        return vertices;
    }

    /**
     * Inserts new node v into the graph and returns its index in the node array.
     * Null elements are not allowed (IllegalArgumentException) and an IndexOutOfBoundsException
     * is thrown if the maximum number of nodes allowed is exceeded.
     */
    public int insertVertex(MyVertex v) throws IllegalArgumentException, IndexOutOfBoundsException {
        if (v == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (numNodes == vertices.length) {
            throw new IndexOutOfBoundsException("Max number of nodes is exceeded");
        }
        vertices[numNodes] = (Node<T>) v;
        return numNodes++;
    }

    /**
     * Returns the weight of the edge between indices v1 and v2 if it exists, otherwise -1.
     * In case of unknown node indices an IllegalArgumentException is thrown.
     */
    public int getEdgeWeight(int v1, int v2) throws IllegalArgumentException {
        checkEdgeArguments(v1, v2);
        return getWeight(adjList, v1, v2);
    }

    private void checkEdgeArguments(int v1, int v2) {
        if (v1 < 0 || v1 >= maxVertices || v2 < 0 || v2 >= maxVertices) {
            throw new IllegalArgumentException("Unknown node index");
        }
        if (vertices[v1] == null || vertices[v2] == null) {
            throw new IllegalArgumentException("Unknown node index");
        }
    }

    private int getWeight(List<Edge> edges, int v1, int v2) {
        for (Edge edge : edges) {
            if (edge.isEdge(v1, v2)) {
                return edge.getWeight();
            }
        }
        return -1;
    }

    /**
     * Inserts an undirected edge with weight between the nodes with indices v1 and v2.
     * The method returns false if the edge already exists, otherwise true.
     * In case of unknown node indices an IllegalArgumentException is thrown.
     */
    public boolean insertEdge(int v1, int v2, int weight) throws IllegalArgumentException {
        checkEdgeArguments(v1, v2);
        if (!contains(v1, v2)) {
            adjList.add(new Edge(v1, v2, weight));
            return true;
        }
        return false;
    }

    private boolean contains(int v1, int v2) {
        for (Edge edge : adjList) {
            if (edge.isEdge(v1, v2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an NxN adjacency matrix for this graph, where N = getNumVertices().
     * The matrix contains the weights of the edges (>=0).
     */
    public int[][] getAdjacencyMatrix() {
        int[][] adj = new int[numNodes][numNodes];
        for (int i = 0; i < numNodes; i++) {
            int[] array = new int[numNodes];
            adj[i] = array;
            for (int j = 0; j < numNodes; j++) {
                array[j] = getEdgeWeight(i, j);
            }
        }
        return adj;
    }

    /**
     * Returns an array of nodes which are adjacent to the node with index v.
     * If the node index v is unknown, an IllegalArgumentException is thrown.
     */
    public MyVertex[] getAdjacentVertices(int v) throws IllegalArgumentException {
        if (v >= getNumberOfVertices() || vertices[v] == null) {
            throw new IllegalArgumentException("Node index is unknown");
        }
        List<Integer> indices = getAdjacentIndices(v);
        MyVertex[] adjVert = new MyVertex[indices.size()];

        for (int i = 0; i < adjVert.length; i++) {
            adjVert[i] = vertices[indices.get(i)];
        }
        return adjVert;
    }

    public List<Integer> getAdjacentIndices(int v) throws IndexOutOfBoundsException {
        if (v >= numNodes) {
            throw new IndexOutOfBoundsException();
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            if(contains(v, i)) {
                indices.add(i);
            }
        }
        return indices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : getAdjacencyMatrix()) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
        System.out.println();
        return "";
    }
}
