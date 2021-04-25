package com.zgz.leetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * 描述:给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * example:
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 思路:
 * 遍历字符串,每次得到的是个字符,然后创建一个map,key是字符Character,value是是字符在字符串中的下标值
 * 如果这个map中存在这个key,就把之前存储的value 取出来,用一个List取存储<Integer>,map中存在这个key表示重复了,那么就从List中
 * 移除这个字符对应的下标值(前一个字符的下标值),不存在这个key,就把这个key对应的value加入到List中
 * 就拿leetcode来打个比如 第一个字符 l  ,map集合中没有这个key, 那么就加入到map集合中,map[l=0],list就把0加入,
 * 第二个字符 e ,判断map集合没有,就加入,这个时候map[l=0,e=1],list集合现在就是[0,1]
 * 第三个字符 e ,这个时候判断,map中就有这个key,这个时候就从map中根据这个key,获取value就是1,list之前保存的数据是[0,1],删除了1,就剩下0,那么这个0就是
 * 第一个不重复出现字符的下标
 *
 */
public class _12字符串找到它的第一个不重复的字符 {
    public static void main(String[] args) {
        System.out.println("res:="+firstUniqChar("leetcode"));
        System.out.println("result:="+firstUniqChar("loveleetcode"));
    }
    /**
     * @param s leetcode
     * @return
     */
    public static int firstUniqChar(String s) {
        if(s==null || s.length()==0) {
            return -1;
        }
        Map<Character,Integer> charsPositions = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(charsPositions.containsKey(s.charAt(i))) {
                Integer charFirstPosition = charsPositions.get(s.charAt(i));
                list.remove(charFirstPosition);
            } else {
                charsPositions.put(s.charAt(i),i);
                list.add(i);
            }
        }
        return list.isEmpty()?-1:list.get(0);
    }
}

