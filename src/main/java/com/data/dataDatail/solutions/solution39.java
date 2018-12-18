package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/12/3 11:06
 * @Description: 恢复旋转排序数组
 * <p>
 * 三步翻转法：以{4,5,6,7,1,2,3}为例
 * <p>
 * 先找到1的位置.然后翻转{4,5,6,7}得到{7,6,5,4}
 * <p>
 * 翻转{1,2,3}得到{3,2,1}
 * <p>
 * 此时数组为：{7,6,5,4,3,2,1}, 将其翻转即得{1,2,3,4,5,6,7}
 */
public class solution39 {


    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here

        if (nums == null) {
            return;
        }
        Integer n = nums.get(0);
        int j = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < n) {
                j = i;
                break;
            }
        }
        resver(nums, 0, j-1);
        resver(nums, j, nums.size()-1);
        resver(nums, 0, nums.size()-1);
        System.out.println(nums);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        recoverRotatedSortedArray(list);
    }


    public static void resver(List<Integer> nums, int from, int to) {
        float x = from;
        float y = to;
        float b = (x+y)/2;
        for(int i = from;i<b;i++){
            int left = nums.get(i);
            int right = nums.get(to-i+from);
            nums.set(i,right);
            nums.set(to-i+from,left);
        }
    }

}
