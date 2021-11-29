package com.company;

public class AVLNode<T extends Comparable<T>> {

    public AVLNode<T> parent = null; // Pointer to the parent node
    public AVLNode<T> left = null; // Pointer to the left child-node
    public AVLNode<T> right = null; // Pointer to the right сhild-node
    public T data; // Content of the node
    public int height; // To be able to calculate the height in O(1)

    public AVLNode(T elem) {
        this.data = elem;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
