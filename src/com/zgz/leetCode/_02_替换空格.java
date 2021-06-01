package com.zgz.leetCode;
/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class _02_替换空格 {
    public static void main(String[] args) {
        String  str = "We are";
        System.out.println("len:="+str.length());
//        System.out.println(replaceSpace2(str));
        System.out.println(replaceSpace3(str).length());
    }
    /**
     * 使用String类的replaceAll方法
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        return s.replaceAll(" ","%20");
    }

    /**
     * 不使用String给我们提供的replaceAll方法
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)==' '?"%20":s.charAt(i));
        }
        return sb.toString();
    }
    /**
     * 思路:是把每个字符都看成' ',那么换成char数组的话就是原来的长度*3了,然后遍历字符串找到每个字符,判断是不是' ' ,最后字符串的通过字符数组中从哪到哪
     * 构建一个字符串
     * @param s
     * @return
     */
    public static String replaceSpace3(String s) {
        //获取字符串的长度
        int len = s.length();
        //这是把每个字符都看作是一个空格的话放到一个char数组中,数组的长度应该是len*3 (因为一个空格等于%20是三个字符)
        char[] array = new char[len*3];
        int size = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c==' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else{
                array[size++] = c;
            }
        }
        String str = new String(array,0,size);
        return str;
    }
}
