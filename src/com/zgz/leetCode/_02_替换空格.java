package com.zgz.leetCode;
/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class _02_替换空格 {
    public static void main(String[] args) {
        String  str = "We are happy.";
        System.out.println(replaceSpace(str));
    }
    /**
     * 使用String类的replaceAll方法
     * @param s
     * @return
     */
//    public static String replaceSpace(String s) {
//        if(s==null||s.length()==0){
//            return "";
//        }
//        return s.replaceAll(" ","%20");
//    }

    /**
     * 不使用String给我们提供的replaceAll方法
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)==' '?"%20":s.charAt(i));
        }
        return sb.toString();
    }
}
