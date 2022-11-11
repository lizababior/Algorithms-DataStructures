package minheap;

import dijkstra.MyMinHeap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> implements MyMinHeap<T> {

    private T[] heap;
    private int size;

    public MinHeap(int initCapacity) {
        this.size = 0;
        this.heap = (T[]) new Comparable[initCapacity + 1];
    }

    public MinHeap(T[] list) {
        this.heap = list;
        this.size = list.length;
        makeHeap();
    }

    private void makeHeap() {
        int last = size() - 1;
        for (int i = getParentIndex(last); i >= 0; i--) {
            downHeap(i);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T val) throws IllegalArgumentException {
        if (val == null) {
            throw new IllegalArgumentException("Null value");
        }
        checkCapacity();
        heap[size] = val;
        size++;
        upHeap(size() - 1);
    }

    private void checkCapacity() {
        if (size() == heap.length) {
            heap = Arrays.copyOf(heap, heap.length + 1);
        }
    }

    @Override
    public T removeMin() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        T minItem = heap[0];
        heap[0] = heap[size() - 1];
        heap[size() - 1] = null;
        size--;
        downHeap(0);
        return minItem;
    }

    @Override
    public T min() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap[0];
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size()];
        for (int i = 0; i < size(); i++) {
            arr[i] = heap[i];
        }
        return arr;
    }

    @Override
    public String toString() {
        int start = 0;
        int levelSize = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (start < size()) {
            for (int i = start; i < start + levelSize && i < size(); i++) {
                sb.append(heap[i] + " ");
            }
            start += levelSize;
            levelSize *= 2;
        }
        return sb.append("]").toString();
    }

    private void upHeap(int index) {
        while (hasParent(index) && heap[index].compareTo(parent(index)) <= 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void downHeap(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) <= 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap[index].compareTo(heap[smallerChildIndex]) <= 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void swap(int index1, int index2) {
        T tmp;
        tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size();
    }

    private boolean hasParent(int index) {
        return index != 0 && getParentIndex(index) >= 0;
    }

    private T leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private T rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private T parent(int index) {
        return heap[getParentIndex(index)];
    }

    public boolean contains(T val) throws IllegalArgumentException {
        if (val == null) {
            throw new IllegalArgumentException("Null value is not allowed");
        }
        if (isEmpty()) {
            return false;
        }
        if (val.compareTo(min()) < 0) {
            return false;
        }

        return recursiveSearch(val, 0);
    }

    private boolean recursiveSearch(T val, int i) {
        if (heap[i].equals(val)) {
            return true;
        }
        if (hasLeftChild(i)) {
            if (heap[getLeftChildIndex(i)].compareTo(val) <= 0) {
                return recursiveSearch(val, getLeftChildIndex(i));
            } else if (hasRightChild(i)) {
                if (heap[getRightChildIndex(i)].compareTo(val) <= 0) {
                    return recursiveSearch(val, getRightChildIndex(i));
                }
                i++;
                return recursiveSearch(val, i);
            }
        }
        return false;
    }

        public static <T extends Comparable<T>>void sort (T list[]) throws IllegalArgumentException {
            if (list != null) {
                MinHeap<T> heap = new MinHeap<>(list);
                int last = list.length - 1;
                while (last > 0) {
                    T min = heap.removeMin();
                    list[last] = min;
                    last--;
                }
            } else {
                throw new IllegalArgumentException("Null value is not allowed");
            }
        }

    }
