package com.data.basejava.arrays;

import java.util.Arrays;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 14:49
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        //数组二分查找
        int data[] = new int[] {1,4,64,65,34,32,234,2};
        Arrays.sort(data);
        System.out.println(Arrays.binarySearch(data,1));

        //数组比较
        int dataA[] = new int[] {1,2,3,4};
        int dataB[] = new int[] {1,2,3,4};
        System.out.println(Arrays.equals(dataA,dataB));

        Arrays.fill(dataA,2);

        System.out.println(Arrays.toString(dataA));
    }
}
