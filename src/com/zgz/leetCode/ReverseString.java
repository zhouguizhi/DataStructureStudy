package com.zgz.leetCode;
/**
 *https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符
 *
 * 比如:
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class ReverseString {
    private static char[] s = {'h','e','l','l','o'};
    public static void main(String[] args) {
        reverseString(s);
        for(char c:s){
            System.out.println("c:="+c);
        }
    }
    /**
     * 思路:利用快慢指针
     * @param s
     */
    public static void reverseString(char[] s) {
        if(s==null||s.length==0){
            return;
        }
        int end = s.length-1;
        int start=0;
        char temp = ' ';
        while (start<end){
           temp = s[start];
           s[start++] = s[end];
           s[end--]  = temp;
       }
    }
}
