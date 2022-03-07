package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] integers = {6, 7, -5, 4, 2, 10, 0, 1};
        new MergeSort<>(integers).sort();

        runBinarySearchRecursively(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 7, 0, 9);
    }

    public static int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearchRecursively(sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(sortedArray, key, middle + 1, high);
        }
    }
}
