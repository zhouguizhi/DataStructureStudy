package com.zgz.dynamicArray;

public class MyArrayList implements MyList<Integer>{
    private int size;
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 6;
    public MyArrayList(int capacity){
        capacity = capacity<DEFAULT_CAPACITY?DEFAULT_CAPACITY:capacity;
        elements = new int[capacity];
    }
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isContains(Integer element) {
        return indexOf(element)!=-1;
    }

    @Override
    public void add(Integer element) {
        elements[size++] = element;
    }

    @Override
    public Integer get(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        return elements[index];
    }

    @Override
    public Integer set(int index, Integer element) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        int oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index,Integer element) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        elements[index] = element;
    }

    @Override
    public Integer remove(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
        System.out.println("index="+index);
        for(int i=0;i<size;i++){
            System.out.println("i="+elements[i]);
            if(i>=index){
                elements[i] = elements[i+1];
            }
        }
        size--;
        return elements[index];
    }

    @Override
    public void removeAll() {

    }
    @Override
    public void clear() {
        size=0;
    }

    @Override
    public int indexOf(int element) {
        for(int i=0;i<size;i++){
            if(elements[i]==element){
                return i;
            }
        }
        return -1;
    }
}
