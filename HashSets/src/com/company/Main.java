package com.company;

public class Main {

    public static void main(String[] args) {
        ChainingHashSet<Integer> chs = new ChainingHashSet<>();

        for (int i = -8; i < 50; i++) {
            chs.insert(i);
        }
        System.out.println(chs);
        chs.clear();
        System.out.println(chs);


        OrderedDoubleHashSet<Integer> odhs = new OrderedDoubleHashSet<>();
        odhs.size();
        odhs.insert(19);
        odhs.insert(27);
        odhs.insert(36);
        odhs.insert(10);
        odhs.insert(64);

        System.out.println(odhs);
    }
}
