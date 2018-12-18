package com.data.dataDatail.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ljh
 * @Date: 2018/12/6 17:03
 * @Description: 两数之和
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 * <p>
 * 样例
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
 * <p>
 * 挑战
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * <p>
 * 先遍历一遍数组，建立HashMap映射，然后再遍历一遍，开始查找，找到则记录index
 */
public class solution56 {


    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int index[] = new int[2];
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            m.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int n = target - numbers[i];
            if (m.containsKey(n) && m.get(n) != i) {
                index[0] = i;
                index[1] = m.get(n);
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 11, 15};
        int targer = 9;
        System.out.println(twoSum(a, targer));
    }
}
