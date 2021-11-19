package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        MinHeap.sort(arr);

        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(4);

        System.out.println(minHeap);

        int n = 1;
        System.out.println("Contains " + n + "? " + minHeap.contains(n));
        n = 0;
        System.out.println("Contains " + n + "? " + minHeap.contains(n));
        n = 5;
        System.out.println("Contains " + n + "? " + minHeap.contains(n));
        n = 3;
        System.out.println("Contains " + n + "? " + minHeap.contains(n));
        n = 30;
        System.out.println("Contains " + n + "? " + minHeap.contains(n));

        System.out.println("Size: " + minHeap.size());
    }
}
