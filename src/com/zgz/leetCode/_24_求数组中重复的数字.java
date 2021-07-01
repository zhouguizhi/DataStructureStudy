package com.zgz.leetCode;
import java.util.HashMap;
import java.util.Map;
/**
 * 1000个数范围是[0,999]，有两个相同的数，请找出这个数
 */
public class _24_求数组中重复的数字 {
    private static final int size = 100;
    public static void main(String[] args) {
        int[] data = new int[size]; // 添加测试数据
        for (int k = 0; k < data.length; k++)
        {
            data[k] = k + 1;
        }
        //这是任意添加一个重复数据 表示567 是数组中重复的数据
        data[80] = 7;
        System.out.println(findNum(data));
    }
    public static int findNum(int[] nums){
        if(nums==null||nums.length<=1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return  map.get(i);
            }else {
                map.put(nums[i],i);
            }
        }
        return 0;
    }
}
