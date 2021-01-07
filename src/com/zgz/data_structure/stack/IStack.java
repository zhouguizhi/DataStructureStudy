package com.zgz.data_structure.stack;

public interface IStack {
    int size();
    boolean isEmpty();
    //查看栈定元素
    int peek();
    //添加元素
    void push(int num);
    //移除栈定元素
    int pop();
}
