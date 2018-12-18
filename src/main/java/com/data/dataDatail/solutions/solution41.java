package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/3 15:55
 * @Description: 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class solution41 {


    public static  int maxSubArray(int[] nums) {
        // write your code here

        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int dp[] = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {

            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] a ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}



