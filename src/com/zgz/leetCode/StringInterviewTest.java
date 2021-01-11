package com.zgz.leetCode;
import java.util.HashMap;
import java.util.Map;
/**
 * 题目:题目:输入“aaaaabbbbccc”,输出“a5b4c3”
 * 这个题目简单 就不分析了,直接用map key是字符,value是这个字符出现的次数
 *
 */
public class StringInterviewTest {
    public static void main(String[] args) {
        System.out.println("输出结果:"+test("aaaaabbbbccc"));
    }
    public static String test(String str){
        if(str==null||str.length()==0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int key = map.get(str.charAt(i))+1;
                map.put(str.charAt(i),key);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            sb.append(key).append(value);
        }
        return sb.toString();
    }
}
