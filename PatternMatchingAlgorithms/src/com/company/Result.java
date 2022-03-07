package com.company;

import java.util.ArrayList;

public class Result {
    boolean found;
    int occurrences;
    ArrayList<Integer> indices;

    public Result() {
        found = false;
        occurrences = 0;
        indices = new ArrayList<>();
    }

    public boolean isFound() {
        return found;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public ArrayList<Integer> getIndices() {
        return indices;
    }

    @Override
    public String toString() {
        return "found=" + found + ", occurrences=" + occurrences + ", indices=" + indices;
    }
}
