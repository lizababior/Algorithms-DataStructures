package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        for(int i = 10; i >= 1; i--) {
            list.addLast(i);
        }

        System.out.println(list);
        System.out.println("Size: " + list.size());
        list.addSorted(11);
        System.out.println(list);
        System.out.println("Size: " + list.size());
        list.addSorted(5);
        System.out.println(list);
        System.out.println("Size: " + list.size());
        list.sortASC();
        System.out.println(list);
        list.sortDES();
        System.out.println(list);

        System.out.println("First element removed: " + list.removeFirst());
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("Last element removed: " + list.removeLast());
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println(list);
        int n = 3;
        System.out.println("Does list contain " + n + "? " + list.contains(3));
        System.out.println("Element with index=" + n + " is " + list.get(n));
        System.out.println("Element with index=" + n + " is removed (" + list.remove(n) + ")");
        System.out.println("Size: " + list.size());
        System.out.println(list);
        list.clear();
    }
}
