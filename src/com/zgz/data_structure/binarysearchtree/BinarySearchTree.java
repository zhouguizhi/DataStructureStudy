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
        root = null;
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
        remove(getElement(element));
    }
    public void remove(Node<E> node){
        if(node==null){
            return;
        }
        size--;
        //表示度为2
        if(node.hasTwoChildren()){
            //找到后继节点
            Node<E> sNode = successor(node);
        }
    }
    /**
     * 思路:从根节点开始找 然后遍历节点 拿出值和传入的element进行对比
     * 根据值获取Node节点
     * @param element 节点元素对应的值
     * @return
     */
    private Node<E> getElement(E element){
        Node<E> node = root;
        while (node!=null){
            int cmp = compare(element,node.element);
            if(cmp==0){
                return node;
            }else if(cmp>0){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        return null;
    }
    public boolean contains(E element){
        return getElement(element)!=null;
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

    /**
     * 判断是不是一颗完全二叉树,
     * 首先要知道什么是完全二叉树,概念要弄明白, 这里判断是不是完全二叉树使用层序遍历方式
     * @return
     */
    public boolean isComplete1(){
        if(null==root) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(isLeaf&&!node.isLeaf()){
                return false;
            }
            if(node.hasTwoChildren()){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.left==null&&node.right!=null){
                return false;
            }else{//后面遍历的节点都必须是叶子节点
                isLeaf = true;
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }
    /**
     * 判断是不是一颗完全二叉树,另外一种写法
     * @return
     */
    public boolean isComplete(){
        if(null==root) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(isLeaf&&!node.isLeaf()){
                return false;
            }

            if(node.left!=null){
                queue.offer(node.left);
            }else if(node.right!=null){
                //走到这里是left=null right!=null
                return false;
            }
            if(node.right!=null){
                queue.offer(node.right);
            }else{
                //right=null
                isLeaf = true;
            }
        }
        return true;
    }
    /**
     * 计算二叉树的高度 使用层序遍历
     * @return  返回二叉树的高度
     */
    public int height1(){
        if(root==null){
            return 0;
        }
        int height = 0;
        //存储着每一层元素数量
        int levelSize = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            levelSize--;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            //意味着即将访问下一层
            if(levelSize==0){
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }
    /**
     * 计算二叉树的高度 递归处理
     * @return  返回二叉树的高度
     */
    public int height(){
        return height(root);
    }
    /**
     * 获取某一个节点的高度
     * @param node
     * @return
     */
    public int height(Node<E> node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(height(node.left),height(node.right));
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
    public void postOrderTraversal(Visitor visitor){
        if(null==visitor){
            return;
        }
        postOrderTraversal(root,visitor);
    }
    private void postOrderTraversal(Node<E> node,Visitor visitor){
        if(null==node){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        //访问根节点
        visitor.visit(node.element);
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
        boolean isStop = visitor.visit(node.element);
        if(!isStop){
            inOrderTraversal(node.right,visitor);
        }
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
     * 前序遍历
     */
    public void preOrderTraversal(Visitor visitor){
        if(null==visitor){
            return;
        }
        preOrderTraversal(root,visitor);
    }
    public void preOrderTraversal(Node<E> node,Visitor visitor){
        if(node==null){
            return;
        }
        boolean isStop = visitor.visit(node.element);
        if(!isStop){
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
//    public Node<E> getPredesess(Integer i){
//        return predesess(new Node(i,));
//    }
    /**
     * 获取某个节点的前驱节点
     * @param node
     * @return
     */
    public Node<E> predesess(Node<E> node){
         if(null==node){
             return null;
         }

        Node<E> leftNode = node.left;
        if(leftNode!=null){
            while (leftNode.right!=null){
                leftNode = leftNode.right;
            }
            return leftNode;
         }
        while (node.parent!=null&&node==node.parent.left){
           node =  node.parent;
        }
        return node.parent;
    }
    /**
     * 获取某个节点的后继节点
     * @param node
     * @return
     */
    public Node<E> successor(Node<E> node){
        if(null==node){
            return null;
        }

        Node<E> leftNode = node.right;
        if(leftNode!=null){
            while (leftNode.left!=null){
                leftNode = leftNode.left;
            }
            return leftNode;
        }
        while (node.parent!=null&&node==node.parent.right){
            node =  node.parent;
        }
        return node.parent;
    }
    /**
     * 访问器
     * @return
     */
    public static abstract class Visitor<E>{
        public abstract boolean visit(E element);
        public boolean isStop;
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
        /**
         * 判断是不是叶子节点
         * @return
         */
        public boolean isLeaf(){
            return  left==null&&right==null;
        }

        /**
         * 释放有2个子节点
         * @return
         */
        public boolean hasTwoChildren(){
            return left!=null&&right!=null;
        }
    }
}
