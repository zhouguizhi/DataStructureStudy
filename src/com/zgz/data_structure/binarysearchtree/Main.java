package com.zgz.data_structure.binarysearchtree;
import com.zgz.data_structure.binarysearchtree.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        test1();
    }
    private static void test() {
        int[] arr = new int[]{7,4,9,2,5,8,11,3};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        for(int i:arr){
            binarySearchTree.add(i);
        }

        BinaryTrees.print(binarySearchTree);
        System.out.println("");
        binarySearchTree.add(1);
        binarySearchTree.add(12);
        BinaryTrees.print(binarySearchTree);
    }
    private static void test1() {
        int[] arr = new int[]{7,4,9,2,5,8,11,3};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree();
        for(int i:arr){
            binarySearchTree.add(i);
        }

//        BinaryTrees.print(binarySearchTree);
//        System.out.println("");
        binarySearchTree.add(1);
        binarySearchTree.add(12);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.preorderTraversal();
    }
}

