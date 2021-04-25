package com.zgz.leetCode;
/**
 * 题目描述
 * 求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 思路:
 */
public class _04_求1加到n的和 {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(3));
    }
    private static int[] res = {0};
    public static int Sum_Solution(int n) {
        try{
            return res[n];
        }catch(Exception e) {
            System.out.println(">>>>>"+Sum_Solution(n-1));
            return n + Sum_Solution(n-1);
        }
    }
}
