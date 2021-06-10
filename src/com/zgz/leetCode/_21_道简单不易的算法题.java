package com.zgz.leetCode;
/**
 * int a = 10;
 * int b=5;
 * 怎么在不引入其他变量的情况下,让 a 和 b 互换?
 */
public class _21_道简单不易的算法题 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        a = a-b;
        b = a+b;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
