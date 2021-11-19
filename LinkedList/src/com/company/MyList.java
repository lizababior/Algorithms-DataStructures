package com.company;

public interface MyList<T extends Comparable<T>> {
    int size(); //Returns number of elements in the List (in O(1))

    void addFirst(T elem) //Adds the element at the beginning of the list
            throws IllegalArgumentException;

    void addLast(T elem) //Adds the element as end of list
            throws IllegalArgumentException;

    void addSorted(T val) //Adds the element to the list (sorted in asc order)
            throws IllegalArgumentException;

    void sortASC(); //Sorts the list in ascending order

    void sortDES(); //Sorts the list in descending order

    void clear(); //Clears the list by removing all elements (in O(1))

    T removeFirst(); //Returns and removes the first element from the list

    T removeLast(); //Returns and removes the last element from the list

    T getFirst(); //Returns the first element from the list (no removal)

    T getLast(); //Returns the last element from the list (no removal)

    boolean contains(T val) //Returns true if T is in list; false otherwise
            throws IllegalArgumentException;

    T get(int index); //Returns element at specific index position (no removal)

    T remove(int index); //Returns and removes element at specific index position

    String toString(); //Returns a string representation of the list

    Object[] toArray(); //Returns the list as array
}
