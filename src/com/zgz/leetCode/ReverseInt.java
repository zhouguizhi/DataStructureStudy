package com.zgz.leetCode;
/**
 *https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 *描述: 整数反转
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class ReverseInt {
    public static void main(String[] args) {
        System.out.println("reslt:="+reverse1(123));
//        System.out.println("reslt:="+321/10);
    }
    /**
     * 思路:
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x!=0){
            result *=10;
            result+=x%10;
            if(result>max||result<min){
                return 0;
            }
            x/=10;
        }
        return result;
    }
    public static int reverse1(int x) {
        int result = 0;
        while (x!=0){
            int last = x%10;
            x/=10;
            result = result*10+last;
        }
        return result;
    }
}
