package com.company;


import java.util.*;

public class Roadmap extends Graph {
    private int[] distances;
    private Set<Integer> settled;
    private MinHeap<Edge> pq;

    // Creates a new timetable for the maximum number of maxStations at stations.
    public Roadmap(int maxStations) {
        super(maxStations);
        this.distances = new int[maxStations];

        this.settled = new HashSet<>();
        this.pq = new MinHeap<>(maxStations);
    }

    public void dijkstra(int src) {
        for (int i = 0; i < maxVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;

        pq.insert(new Edge(0, 0, 0));

        while (settled.size() != numNodes) {
            if (pq.isEmpty()) {
                return;
            }
            int u = pq.removeMin().getDestination();

            if (!settled.contains(u)) {
                settled.add(u);
                minimumDistance(u, getAdjacentIndices(u));
            }
        }
    }

    private void minimumDistance(int u, List<Integer> adj) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.size(); i++) {
            int v = adj.get(i);

            if (!settled.contains(v)) {
                edgeDistance = getEdgeWeight(v, u);
                newDistance = distances[u] + edgeDistance;

                if (newDistance < distances[v])
                    distances[v] = newDistance;

                pq.insert(new Edge(u, v, distances[v]));
            }
        }
    }


    // Returns (or outputs) the shortest paths from the station "from" to all reachable destinations.
    public void printShortestDistances(int from) {
        dijkstra(from);
        System.out.println("The shortest distances from " + vertices[0]);
        for (int j = 0; j < numNodes; j++) {
            System.out.println("\tto " + vertices[j] + ": " + distances[j] + "km");
        }
    }
}
