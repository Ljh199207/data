package com.data.dataDatail.solutions;

import java.util.Arrays;

/**
 * @Auther: ljh
 * @Date: 2018/12/10 16:32
 * @Description: 中位数
 */
public class solution80 {

    public static void main(String[] args) {
        /*int A[] = {7, 9, 4, 5};
        int a = median(A);
        System.out.println(a);*/

        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int b :arr) {
            System.out.println(b);
        }
    }

    public static int median(int[] nums) {
        // write your code here
        int i = 0;
        int j = nums.length - 1;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return quickSort(nums, i, j);
     /*   Arrays.sort(nums);
        int m = nums.length;

       if(m%2==0){
           return nums[m/2 - 1];
       }
       else {
           return nums[m/2];
       }*/
    }


    public static int quickSort(int[] arr, int left, int right) {


        if (arr == null || left >= right || arr.length <= 1)
            return 0;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
        return  0;
    }

    private static int partition(int[] nums, int start, int end) {
        int priot = nums[start];
        int i = start;
        int j = end;
        while (i < j) {

            //先判断基准数和后面的数依次比较
            while (priot <= nums[j] && i < j) {
                j--;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            // 现在是 arr[right] 需要填坑了
            while (priot>nums[i]&&i<j){
                i++;
            }
            if(i<j){
                nums[j]=nums[i];
                j--;
            }

        }
        nums[i] = priot;
        return i;
    }



}
