package com.data.dataDatail.algorithm.sort;

/**
 * @Auther: ljh
 * @Date: 2018/12/13 10:17
 * @Description: 插入排序   O(N^2)
 */
public class InsertionSort<AnyType extends Comparable<? super AnyType>> {

    void insert(AnyType[] A) {
        int j;
        for (int i = 1; i < A.length; i++) {
            AnyType temp = A[i];
            for (j = i; j > 0 && temp.compareTo(A[j - 1]) < 0; j--) {
                A[j] = A[j - 1];
            }
            A[j] = temp;
        }
    }
    public static void main(String[] args) {

        InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer A[] = {34, 8, 64, 51, 32, 21};
        insertionSort.insert(A);
        for (Integer a : A) {
            System.out.println(a.intValue());
        }
    }
}
