package com.zgz.data_structure.binarysearchtree;
import com.zgz.data_structure.binarysearchtree.printer.BinaryTreeInfo;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <E extends Comparable>  表示传递的元素要实现Comparable接口
 * @param <E>
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
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
            //如果传入进来的值相等,那么就覆盖,为什么要覆盖呢?这个是在自定义对象的时候起作用, 比如Person是按照年龄比较的,
            //那么然后在Person类添加了其他属性, 但是年纪age是相等的,但是添加一个其他属性
            if(compareResult==0){
                node.element = element;
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
    //
    public void levelOrderTraversal(Visitor visitor){
        if(root==null||visitor==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            visitor.visit(node.element);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }
    /**
     * 层序遍历
     * @param
     */
    public void levelOrderTraversal(){
        if(root==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.element);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }
    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node<E> node){
        if(null==node){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        //访问根节点
        System.out.println(node.element);
    }
    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node<E> node){
        if(null==node){
            return;
        }
        inOrderTraversal(node.left);
        //访问根节点
        System.out.println(node.element);
        inOrderTraversal(node.right);
    }
    /**
     * 中序遍历,带自定义的访问
     */
    public void inOrderTraversal(Visitor visitor){
        inOrderTraversal(root,visitor);
    }

    private void inOrderTraversal(Node<E> node,Visitor visitor){
        if(null==node||visitor==null){
            return;
        }
        inOrderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inOrderTraversal(node.right,visitor);
    }
    /**
     * 前序遍历
     */
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    public void preOrderTraversal(Node<E> node){
        if(node==null){
            return;
        }
        System.out.println(node.element);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 访问器
     * @return
     */
    public interface Visitor<E>{
        void visit(E element);
    }
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
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
