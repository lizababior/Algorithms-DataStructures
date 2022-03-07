package com.company;

import java.util.ArrayList;
import java.util.List;

public class DFS extends Graph {

    private List<List<MyVertex>> components;

    public DFS(int maxVertices) {
        super(maxVertices);
        this.components = new ArrayList<>();
    }

    // Returns true if the graph is connected, otherwise false.
    public boolean isConnected() {
        return getNumberOfComponents() == 1;
    }

    // Returns the number of components of the graph.
    public int getNumberOfComponents() {
        components = getComponents(new ArrayList<>());
        return components.size();
    }

    private List<List<MyVertex>> getComponents(List<List<MyVertex>> list) {
        resetVisitedNodes();
        list.add(traverseRecursively(0, new ArrayList<>()));
        for (int i = 1; i < numNodes; i++) {
            if (!vertices[i].isVisited()) {
                list.add(traverseRecursively(i, new ArrayList<>()));
            }
        }
        return list;
    }

    private List<MyVertex> traverseRecursively(int v, ArrayList<MyVertex> component) {
        if (vertices[v] == null) {
            throw new IllegalArgumentException("Graph is empty");
        }
        vertices[v].setVisited(true);
        component.add(vertices[v]);
        List<Integer> arr = getAdjacentIndices(v);
        for (int neighbor : arr) {
            if (!vertices[neighbor].isVisited()) {
                traverseRecursively(neighbor, component);
            }
        }
        return component;
    }

    private void resetVisitedNodes() {
        for (int i = 0; i < numNodes; i++) {
            vertices[i].setVisited(false);
        }
    }

    // Returns true if the graph contains cycles, otherwise false.
    public boolean isCyclic() {
        resetVisitedNodes();
        return isCyclicRecursively(0, -1);
    }

    private boolean isCyclicRecursively(int v, int parent) throws IllegalArgumentException {
        if (vertices[v] == null) {
            throw new IllegalArgumentException("Graph is empty");
        }
        vertices[v].setVisited(true);

        List<Integer> adjInx = getAdjacentIndices(v);
        // do for every edge (v, w)
        for (int w: adjInx) {
            if (!vertices[w].isVisited()) {
                if (isCyclicRecursively(w, v)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    // Outputs the nodes of all components (one line per component).
    public void printComponents() {
        if (numNodes == 0) {
            return;
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<MyVertex> component : components) {
            sb.append(component.toString() + "\n");
        }
        return sb.toString();
    }
}