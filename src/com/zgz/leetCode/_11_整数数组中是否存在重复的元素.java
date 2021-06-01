package com.zgz.leetCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 描述:给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 *
 * 输入: [1,2,3,1]
 * 输出: true
 */
public class _11_整数数组中是否存在重复的元素 {
    public static void main(String[] args) {
        int[] arr= {2,2,3,4,5};
        System.out.println("result:="+findRepeatNum(arr));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0){
            return false;
        }
        //key是数组对应的值,key是数组下标值
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

    /**
     * 这种做法  这是利用Hashset不能重复添加数据 add方法有返回值
     * @param nums
     * @return
     */
    public static boolean findRepeatNum(int[] nums){
        if(null==nums||nums.length==0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(Integer num:nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
