package com.zgz.leetCode;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示 比如9是1001 那么1的个数就是2个
 */
public class _23_二进制1的个数 {
    public static void main(String[] args) {
        System.out.println(getCount(9));
    }
    public static int getCount(int n){
        int count = 0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
