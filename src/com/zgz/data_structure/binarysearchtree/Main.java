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
//         test4();
//        test5();
//        test6();
//          test7();
        test8();
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
    /**
     * 层序遍历测试
     */
    private static void test5() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.levelOrderTraversal(new BinarySearchTree.Visitor<Object>() {
            @Override
            public boolean visit(Object element) {
                System.out.println("_"+element+"_");
                return false;
            }
        });
    }
    //中序遍历测试 增加自定义访问
    private static void test6() {
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);
        binarySearchTree.inOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element+10);
                return false;
            }
        });
    }
    public static void test7(){
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);

        binarySearchTree.preOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                return false;
            }
        });
        binarySearchTree.inOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                return false;
            }
        });
        binarySearchTree.postOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                return false;
            }
        });
        binarySearchTree.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                return false;
            }
        });
    }
    public static void test8(){
        BinarySearchTree<Integer> binarySearchTree = createObj();
        addDataFormArray(binarySearchTree);
        BinaryTrees.println(binarySearchTree);

        System.out.println("根节点的高度:="+binarySearchTree.height1());
    }
    static BinarySearchTree createObj(){
        return new BinarySearchTree();
    }
}

