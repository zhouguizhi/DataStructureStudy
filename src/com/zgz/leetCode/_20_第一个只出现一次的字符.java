package com.zgz.leetCode;
import java.util.HashMap;
import java.util.Map;
/**
 * 题目:第一个只出现一次的字符 比如"leetcode" 返回的是l
 * 思路:使用hashMap key是char value是boolean,然后遍历字符数组
 */
public class _20_第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(test("abcdab"));
    }
    public static char test(String str){
        if(str==null||str.length()==0){
            return ' ';
        }
        Map<Character,Boolean> map = new HashMap<>();
        char[] array = str.toCharArray();
        for(char c:array){
            map.put(c,!map.containsKey(c));
        }
        for(char c:array){
            if(map.containsKey(c)){
                return c;
            }
        }
        return ' ';
    }
}
