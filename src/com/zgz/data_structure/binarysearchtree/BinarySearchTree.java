package com.zgz.data_structure.binarysearchtree;
//import com.zgz.data_structure.binarysearchtree.alnoe.Comparable;
//import com.zgz.data_structure.binarysearchtree.alnoe.Comparator;

import java.util.Comparator;

/**
 * <E extends Comparable>  表示传递的元素要实现Comparable接口
 * @param <E>
 */
public class BinarySearchTree<E>{
    private int size = 0;
    private Node<E> root;//根节点
    public void clear(){
        size=0;
    }
    //比较器
    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    public BinarySearchTree() {
        this(null);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void add(E element){
        checkNotNull(element);
        if(null==root){
            root = new Node<>(element,null);
            size++;
            return;
        }
        //添加不是根节点的元素
        Node<E> node = root;
        Node<E> parent = null;
        int compareResult = 0;
        while (node!=null){
            compareResult = compare(element,node.element);
            parent = node;
            if(compareResult==0){//相等
                return;
            }else if(compareResult>0){//表示在根元素的右边
                node = node.right;
            }else{//表示在根元素的左边
                node = node.left;
            }
        }
        //看看插入到父节点那个位置
        Node<E> newNode = new Node<>(element,parent);
        if(compareResult>0){
            parent.right = newNode;
        }else if(compareResult<0){
            parent.left = newNode;
        }else{

        }
        size++;
    }
    public void remove(E element){
        checkNotNull(element);
    }
    public boolean contains(E element){
        return false;
    }

    /**
     * 返回0 e1=e2 1 e1>e2 -1 el<e2
     * 如果构造函数没有传递Comparator对象进行比较的话,就强制让对象实现Comparable接口进行比较
     * @return
     */
    private int compare(E e1,E e2){
        if(comparator!=null){
            return comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }
    private void checkNotNull(E element){
        if(null==element){
            throw new IllegalArgumentException("非法参数异常");
        }
    }
    private static class Node<E>{
        E element;
        Node<E> left;//左子节点
        Node<E> right;//右子节点
        Node<E> parent;//父节点

        public Node(E element,Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
