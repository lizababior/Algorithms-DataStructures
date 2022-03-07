package com.company;

public class Edge {
    private int source;
    private int destination;
    private int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isEdge(int v1, int v2) {
        if (source == v1 && destination == v2 || source == v2 && destination == v1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
