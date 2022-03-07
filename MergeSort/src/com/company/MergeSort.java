package com.company;

public class MergeSort<T extends Comparable<T>> {

    private final T[] arr;

    public MergeSort(T[] arr) {
        this.arr = arr;
    }

    public void sort() {
        mergeSort(0, arr.length-1);
    }

    private void merge(int low, int middle, int high) {
        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];

        System.arraycopy(arr, low, leftArray, 0, leftArray.length);
        System.arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);

        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;

        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            if (leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0) {
                arr[arrCounter] = leftArray[leftSubArrCounter];
                arrCounter++;
                leftSubArrCounter++;
            } else {
                arr[arrCounter] = rightArray[rightSubArrCounter];
                arrCounter++;
                rightSubArrCounter++;
            }
        }
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        mergeSort(low, middle);
        mergeSort(middle+1, high);
        merge(low, middle, high);
    }
}
