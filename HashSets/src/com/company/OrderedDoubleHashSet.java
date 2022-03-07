package com.company;

import java.util.Arrays;

public class OrderedDoubleHashSet<T extends Comparable<T>> implements MyHashSet {

    private int size;
    private Object[] array;

    public OrderedDoubleHashSet() {
        this.size = 0;
        this.array = new Object[13];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean insert(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            int hash1 = find(key);
            if (!contains(key)) {
                array[hash1] = key;
                size++;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    @Override
    public boolean contains(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            } else if (!isEmpty()) {
                int hash1 = find(key);
                if (array[hash1] != null) {
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    public int find(Object key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);
        while (array[hash1] != null && !array[hash1].equals(key)) {
            hash1 += hash2;
            if (hash1 >= array.length)
                hash1 -= array.length;
        }
        return hash1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Object key) throws IllegalArgumentException {
        try {
            if (key == null) {
                throw new IllegalArgumentException();
            }
            int hash1 = find(key);
            if (array[hash1] != null) {
                array[hash1] = null;
                size--;
                return true;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Null is not allowed");
        }
        return false;
    }

    private int myHash1(Object key) {
        int hashVal = Math.abs(key.hashCode()) % array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private int myHash2(Object key) {
        int prime = getPreviousPrime(array.length);
        int hashVal = Math.abs(key.hashCode());
        hashVal %= prime;
        if (hashVal < 0)
            hashVal += array.length;
        return prime - hashVal % prime;
    }

    private int getPreviousPrime(int num) {
        for (int i = num - 1; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 2;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordered Double HashSet\n");
        sb.append("index   key\n");
        for (int i = 0; i < array.length; i++) {
            sb.append(i + " -->   " + array[i] + "\n");
        }
        return sb.toString();
    }


    @Override
    public void clear() {
        size = 0;
        Arrays.fill(array, null);
    }
}
