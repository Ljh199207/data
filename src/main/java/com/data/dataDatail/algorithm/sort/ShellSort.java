package com.data.dataDatail.algorithm.sort;

/**
 * @Auther: ljh
 * @Date: 2018/12/13 10:56
 * @Description: 希尔排序
 */
public class ShellSort<AnyType extends Comparable<? super AnyType>> {


    public void shellS(AnyType[] A) {

        int j;

        for (int gap = A.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < A.length; i++) {
                AnyType temp = A[i];

                for (j = i; j >= gap && temp.compareTo(A[j - gap]) < 0; j -= gap) {

                    A[j] = A[j - gap];
                }

                A[j] = temp;

            }
        }
    }

    public static void main(String[] args) {
        ShellSort<Integer> shellSort = new ShellSort<>();
        Integer A[]={81,94,11,96,12,35,17,95,28,58,41,75,15};
        System.out.println("start:"+System.currentTimeMillis());
        shellSort.shellS(A);
        System.out.println("end："+System.currentTimeMillis());
        for (Integer integer:A){
            System.out.println(integer);
        }
    }
}
