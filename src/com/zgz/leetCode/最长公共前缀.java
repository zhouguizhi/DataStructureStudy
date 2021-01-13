package com.zgz.leetCode;
import java.util.Arrays;
/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""
 * example:
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"flower","flaw","flight"};
        System.out.println(longestCommonPrefix1(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        for(String str:strs){
            System.out.println(str+":");
        }
        String first = strs[0];
        String last = strs[strs.length-1];
        int limit = Math.min(first.length(),last.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<limit;i++){
            if(first.charAt(i)==last.charAt(i)){
                sb.append(first.charAt(i));
            }else {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 思路:假如我们给的字符串数组是:{"flower","flaw","flight"}
     * 先获取到数组的第一个字符串也就是flower,
     * indexOf():查找指定字符或字符串在字符串中第一次出现地方的索引，未找到的情况返回 -1.
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String res = strs[0];
        System.out.println("flower".indexOf("fla"));
        for(String str:strs){
            while (str.indexOf(res)!=0){
                res = res.substring(0,res.length()-1);
            }
        }
        return res;
    }
}
