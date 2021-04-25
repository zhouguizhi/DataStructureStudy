package com.zgz.leetCode;

public class _15_斐波那契 {
    public static void main(String[] args) {
//        System.out.println(fib1(3));
//        System.out.println(fib1(4));
//        System.out.println(fib1(5));
//        System.out.println(fib1(6));
        System.out.println(fib2(7));
    }

    /**
     * 这个做法效率很低 原因是在于会重复算之前位置的数据
     * @param n
     * @return
     */
    public static int fib1(int n){
        if(n<=1) return n;
        return fib1(n-1)+fib1(n-2);
    }

    /**
     * 第二种做法效率很高,他会把之前求和数据会保存起来
     * @param n
     * @return
     */
    public static int fib2(int n){
        if(n<=1) return n;
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
