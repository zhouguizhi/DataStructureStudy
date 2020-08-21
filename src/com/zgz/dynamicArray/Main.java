package com.zgz.dynamicArray;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(0,7);
        list.add(list.size(),8);
        System.out.println(list);
    }
}
