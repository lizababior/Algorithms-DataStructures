package com.company;

import java.util.Arrays;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Size: " + tree.size());

        System.out.println(Arrays.toString(tree.toArray()));

        tree.remove(30);

        System.out.println("Size: " + tree.size());

        System.out.println(Arrays.toString(tree.toArray()));

        System.out.println(tree.height());
    }
}
