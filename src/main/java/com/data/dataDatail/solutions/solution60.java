package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/6 17:23
 * @Description: 搜索插入位置
 */
public class solution60 {

    public static int searchInsert(int[] A, int target) {
        // write your code here
        int start = 0;
        int end = A.length - 1;
        while (start <=end) {
            int middle = (end + start) / 2;
            if (target < A[middle]) {
                end = middle - 1;
            } else if (target > A[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
      return  start;
    }

    public static void main(String[] args) {
        int [] A ={1,3,5,6,8,10};
        int a = 7;
        System.out.println(searchInsert(A,a));
    }
}
