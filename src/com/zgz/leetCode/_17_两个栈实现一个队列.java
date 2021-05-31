package com.zgz.leetCode;
import java.util.Stack;
/**
 * 两个栈实现一个队列
 * 栈特点:先进后出
 * 队列特点:先进先出
 * 思路:首先要知道栈和队列的特点,我们知道栈是先进后出,而队列是先进先出,比如 进入栈分别是1,2,3,4怎么做到1先出来
 */
public class _17_两个栈实现一个队列 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {
        push();
        pop();
    }

    private static void pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /**
     * 入栈 添加数值
     */
    private static void push() {
        stack1.push(1);
        stack1.push(3);
        stack1.push(5);
        stack1.push(7);
        stack1.push(9);
    }
}
