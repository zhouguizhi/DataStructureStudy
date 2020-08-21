package com.zgz.dynamicArray;

public class Main {
    public static void main(String[] args) {
        //添加 1111 2222
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.remove(4));
    }
}
