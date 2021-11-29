package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyBinarySearchTree<Integer> intTree = new MyBinarySearchTree<>();
        //test(intTree);
        intTree.insert(10);
        intTree.insert(1);
        intTree.insert(5);
        intTree.insert(15);
        intTree.insert(20);
        intTree.insert(0);
        intTree.insert(11);

        System.out.println("PostOrder : " + Arrays.toString(intTree.toArrayPostOrder()));
        System.out.println("InOrder : " + Arrays.toString(intTree.toArrayInOrder()));
        System.out.println("PreOrder : " + Arrays.toString(intTree.toArrayPreOrder()));
    }

    public static void test(MyBinarySearchTree<Integer> intTree) {
        intTree.insert(15);
        intTree.insert(5);
        intTree.insert(12);
        intTree.insert(3);
        intTree.insert(16);
        intTree.insert(20);
        intTree.insert(18);
        intTree.insert(23);
        intTree.insert(10);
        intTree.insert(13);
        intTree.insert(6);
        intTree.insert(7);

        System.out.println(intTree.remove(15));

        System.out.println("Contains? " + intTree.find(10));
        System.out.println(intTree.find(5));

        System.out.println(intTree.isRoot(5));

        System.out.println("Size: " + intTree.size());

        System.out.println("PostOrder : " + Arrays.toString(intTree.toArrayPostOrder()));
        System.out.println("InOrder : " + Arrays.toString(intTree.toArrayInOrder()));
        System.out.println("PreOrder : " + Arrays.toString(intTree.toArrayPreOrder()));

        System.out.println(intTree.getParent(61));
        System.out.println(intTree.isRoot(15));
        System.out.println(intTree.isExternal(7));
        System.out.println(intTree.isExternal(15));
    }
}
