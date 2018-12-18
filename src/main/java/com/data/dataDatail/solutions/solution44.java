package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/12/3 16:58
 * @Description: 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 */
public class solution44 {

    public static int minSubArray(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        if(len==0){
            return 0;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums.get(0));
        for(int i=1;i<nums.size();i++){
            dp.add(Math.min(nums.get(i),dp.get(i-1)+nums.get(i)));
        }
        int res =Integer.MAX_VALUE;
        for(int i =0;i<dp.size();i++){
            res = Math.min(dp.get(i),res);
        }

        return  res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        System.out.println(minSubArray(list));
    }
}
