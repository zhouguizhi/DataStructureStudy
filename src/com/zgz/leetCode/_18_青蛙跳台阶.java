package com.zgz.leetCode;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 思路:得到n个台阶，一共可以跳多少个2步,这个也是一个斐波那契数列的一个应用。对于本题前提只有一次跳一阶，和跳两阶。如果两种跳法，1阶或者2阶，
 * 那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f（n - 1）假定第一次跳的是2阶，那么剩下的是n-2个台阶，
 * 跳法是f(n - 2)那么这个时候就能够得到总的跳法为 f(n) = f(n - 1) + f(n - 2)，然后这个出口就是:只有一阶的时候f(1) = 1,
 * 只有两阶的时候f(2) = 2
 */
public class _18_青蛙跳台阶 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
    public static int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        //第一次有两种选择，然后根据不同的选择，然后开始不同的下一步，但是下一步还是一样有两种选择
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
    public static int JumpFloor2(int target) {
        int x=1, y=2, z;
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        for(int i = 3; i <= target; i ++){
            z = y;
            y = x + y;
            x = z;
        }
        return y;
    }
}
