package com.zgz.leetCode;
/**
 * 求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路:之前一般这种题目都是(1+n)*n/2 现在是要求不能使用乘除法,只能使用递归了
 */
public class _19_实现求1到n的求和 {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }
    public static int sum(int n) {
        int sum = n;
        // 递归终止条件，借助&&的短路，对于 A && B
        boolean isContinue = (n > 0) && (sum += sum(--n)) > 0;
        return sum;
    }
}
