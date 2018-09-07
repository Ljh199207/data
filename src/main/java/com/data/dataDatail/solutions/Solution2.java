package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/8/24 15:43
 * @Description:
 */
public class Solution2 {

    public static void main(String[] args) {
        System.out.println( AaddB(325, 854));
        System.out.println(AaddB2(325, 854));
    }


    /**
     * 功能描述:  A+B 的问题  循环
     *
     * @param: [a, b]
     * @return: int
     * @auther: ljh
     * @date: 2018/8/24 15:44
     */
    public static int AaddB(int a, int b) {

        while (b != 0) {
            int tmpa = a ^ b;
            int tmpb = (a & b) << 1;
            a = tmpa;
            b = tmpb;
        }
        return a;
    }

    // 递归
    public static int AaddB2(int a, int b) {

        if(b==0){
            return a ;
        }
        int tmpa = a ^ b;
        int tmpb = (a & b) << 1;
        return  AaddB2(tmpa,tmpb);
    }


}
