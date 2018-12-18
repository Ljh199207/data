package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/12/4 14:39
 * @Description:
 */
public class solution50 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(productExcludeItself(list));
        System.out.println(productExcludeItself2(list));
    }

    // 暴力法  两个for 解决
    public static List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> list = new ArrayList<>();
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            long count = 1;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    count *= nums.get(j);
                } else continue;

            }
            list.add(count);
        }
        return list;
    }

    //分治法
    public static List<Long> productExcludeItself2(List<Integer> nums) {
        // write your code here
        List<Long> list = new ArrayList<>();
        if (nums == null || nums.size() == 1) {
            long bi = 1;
            list.add(bi);
            return list;
        }
        Long[] left = new Long[nums.size()];
        Long[] right = new Long[nums.size()];
        left[0] = 1L;
        for(int i=1;i<nums.size();i++){
            left[i] =left[i-1]*nums.get(i-1);
        }
        right[nums.size()-1]=1L;
        for(int i =nums.size()-2;i>=0;i--){
            right[i] =right[i+1]*nums.get(i+1);
        }
        for(int i=0;i<nums.size();i++){
            long res = right[i] * left[i];
            list.add(res);
        }
        return list;
    }
}
