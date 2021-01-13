package com.zgz.lesson01;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(method02(64));
        System.out.println(method01(64));
    }
    /**
     * 递归实现斐波那契 缺点是当数据量大的时候性能特别的差 因为
     */
    private static int method01(int n){
        if(n<=1){
            return n;
        }
        return method01(n-1)+method01(n-2);
    }

    /**
     * 效率最好
     */
    private static int method02(int n){
        if(n<=1){
            return n;
        }
        int first = 0;
        int second = 1;
        for(int i=0;i<n-1;i++){
            int sum = first+second;
            first = second;
            second = sum;
        }
        return second;
    }
}
