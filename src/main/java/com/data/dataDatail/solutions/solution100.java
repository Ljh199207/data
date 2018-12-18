package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/17 11:38
 * @Description:
 */
public class solution100 {

    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }

    public static void main(String[] args) {


        int A[] = {1,2,3,2,1};
        System.out.println(removeDuplicates(A));

    }

}
