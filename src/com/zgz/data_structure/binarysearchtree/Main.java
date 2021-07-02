package com.zgz.data_structure.binarysearchtree;
import com.zgz.data_structure.binarysearchtree.printer.BinaryTrees;
/**
 * 测试
 */
public class Main {
    static int[] arr = new int[]{7,4,9,2,5,8,11,3,1,12};
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
          test4();
    }
    private static void test() {
        BinarySearchTree<Integer> binarySearchTree =createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.print(binarySearchTree);
        BinaryTrees.print(binarySearchTree);
    }
    public static void addDataFormArray(BinarySearchTree<Integer> binarySearchTree){
        for(int i:arr){
            binarySearchTree.add(i);
        }
    }
    /**
     * 测试前序遍历
     */
    private static void test1() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.preOrderTraversal();
    }
    /**
     * 测试中序遍历
     */
    private static void test2() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.inOrderTraversal();
    }
    /**
     * 后序遍历测试
     */
    private static void test3() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.postOrderTraversal();
    }
    /**
     * 层序遍历测试
     */
    private static void test4() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.levelOrderTraversal();
    }
    static BinarySearchTree createObj(){
        return new BinarySearchTree();
    }
}

