package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private BinaryTreeNode<T> root;
    private int size;

    public MyBinarySearchTree() {
        this.root = null;
    }

    @Override
    public void insert(T elem) throws IllegalArgumentException {
        if (elem == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (containsKey(root, elem)) {
            throw new IllegalArgumentException("Duplicates are not allowed");
        }
        root = insertRec(root, elem);
        size++;
    }

    private BinaryTreeNode<T> insertRec(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            root = new BinaryTreeNode<>(key);
            return root;
        }

        if (root.getData().compareTo(key) > 0) {
            root.setLeft(insertRec(root.getLeft(), key));
        } else if (root.getData().compareTo(key) < 0) {
            root.setRight(insertRec(root.getRight(), key));
        }

        return root;
    }

    @Override
    public T find(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        if (containsKey(root, key)) {
            return key;
        }
        return null;
    }

    private boolean containsKey(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            return false;
        }
        if (root.getData().equals(key)) {
            return true;
        }
        if (root.getData().compareTo(key) > 0) {
            return containsKey(root.getLeft(), key);
        }
        return containsKey(root.getRight(), key);
    }

    @Override
    public boolean remove(T key) throws IllegalArgumentException {
        size--;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArrayPostOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        PostOrderRec(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void PostOrderRec(BinaryTreeNode n, List arr) {
        if (n == null) {
            return;
        }
        int i = 0;
        PostOrderRec(n.getLeft(), arr);
        PostOrderRec(n.getRight(), arr);
        arr.add(n.getData());
    }

    @Override
    public Object[] toArrayInOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        printInOrder(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void printInOrder(BinaryTreeNode n, List arr) {
        if (n == null) {
            return;
        }
        printInOrder(n.getLeft(), arr);
        arr.add(n.getData());
        printInOrder(n.getRight(), arr);
    }

    @Override
    public Object[] toArrayPreOrder() {
        List<Object> arr = new ArrayList<>();
        Object[] brr = new Object[this.size];
        printPreOrder(root, arr);
        int i = 0;
        for (Object elem : arr) {
            brr[i++] = elem;
        }
        return brr;
    }

    public void printPreOrder(BinaryTreeNode n, List arr) {
        if (n == null) {
            return;
        }
        arr.add(n.getData());
        printPreOrder(n.getLeft(), arr);
        printPreOrder(n.getRight(), arr);
    }

    @Override
    public T getParent(T key) throws IllegalArgumentException {
        return findParentRec(root, key);
    }

    public T findParentRec(BinaryTreeNode root, T key) {
        if (root == null || key == null) {
            return null;
        } else if ((root.getRight() != null && root.getRight().getData() == key)
                || (root.getLeft() != null && root.getLeft().getData() == key)) {
            return (T) root.getData();
        } else {
            T found = findParentRec(root.getRight(), key);
            if (found == null) {
                found = findParentRec(root.getLeft(), key);
            }
            return found;
        }
    }

    @Override
    public boolean isRoot(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }
        return getParent(key) == null;
    }

    @Override
    public boolean isInternal(T key) throws IllegalArgumentException {
        return false;
    }

    @Override
    public boolean isExternal(T key) throws IllegalArgumentException {
        return false;
    }
}
