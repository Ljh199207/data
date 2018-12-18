package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/11 11:34
 * @Description: 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
 */
public class solution82 {


    public static int singleNumber(int[] A) {
        // write your code here

        if(A==null||A.length==0){
            return 0;
        }
        int a=A[0];
        for(int i =1;i<A.length;i++){
            a=a^A[i];
        }

        return a;
    }

    public static void main(String[] args) {
        int A[]={1,2,2,1,3,4,3};
        System.out.println(singleNumber(A));
    }
}
