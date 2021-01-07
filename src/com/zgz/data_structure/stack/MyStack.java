package com.zgz.data_structure.stack;
import java.util.ArrayList;
import java.util.List;
/**
 * 栈
 */
public class MyStack implements IStack{
    private List<Integer> list;
    public MyStack(){
        list = new ArrayList<>();
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println("size:="+myStack.size());
        System.out.println("isEmpty:="+myStack.isEmpty());
        System.out.println("peek:="+myStack.peek());
        System.out.println("pop:="+myStack.pop());
        System.out.println("size:="+myStack.size());
    }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public int peek() {
        return list.get(list.size()-1);
    }
    @Override
    public void push(int num) {
        list.add(num);
    }
    @Override
    public int pop() {
        int index  = list.remove(list.size()-1);
        return index;
    }
}
