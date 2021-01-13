package com.zgz.leetCode;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 *
 */
public class 翻转字符串里的单词 {
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
    }

    /**
     * 思路使用栈思想先把字符串放入栈中,然后一个个弹出来，这也是一种实现方式
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        s = s.trim();
        Stack<String> stack = new Stack<>();
        String[] arrStr = s.split(" ");
        for(int i=0;i<arrStr.length;i++){
            stack.push(arrStr[i]);
            stack.push(" ");
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString().trim();
    }

    /**
     * 思路:这个想法更简单,直接切割" "， 然后得到一个字符串数组,进行遍历,因为它是一个句子,所以每个字符串之间一定是有空格的
     * @param str
     * @return
     */
    public static String reverseWords1(String str) {
        if(str == null || str.length()==0) {
            return str;
        }
        str = str.trim();
        String[] splits = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = splits.length - 1; i >= 0; i--) {
            sb.append(splits[i] + " ");
        }
        return sb.toString().trim();
    }
}
