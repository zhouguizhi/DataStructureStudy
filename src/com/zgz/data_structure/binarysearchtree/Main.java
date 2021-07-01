package com.zgz.data_structure.binarysearchtree;

public class Main {
    public static void main(String[] args) {
        test();
    }
    private static void test() {
        int[] arr = new int[]{7,4,9,2,5,8,11,3};
        BinarySearchTree1<Integer> binarySearchTree1 = new BinarySearchTree1();
        for(int i:arr){
            binarySearchTree1.add(i);
        }
    }
}

