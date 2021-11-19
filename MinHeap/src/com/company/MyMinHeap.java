package com.company;

import java.util.NoSuchElementException;

public interface MyMinHeap<T extends Comparable<T>> {

    boolean isEmpty(); //true if Heap is empty, false otherwise

    int size(); //returns the amount of elements in the Heap

    void insert(T val) //inserts the val data into the Heap
            throws IllegalArgumentException;

    T removeMin() //removes and returns the minimum element
            throws NoSuchElementException;

    T min() //returns the minimum element
            throws NoSuchElementException;

    Object[] toArray(); //returns an array representation of the Heap

    String toString(); //returns a string representation of the Heap
}
