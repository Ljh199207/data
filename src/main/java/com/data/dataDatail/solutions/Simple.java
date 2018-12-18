package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/11/26 09:58
 * @Description:
 */
public class Simple {
    public static int reverseInteger(int number) {
        int i = number / 100;
        int j = number / 10 % 10;
        int k = number % 10;
        return k * 100 + j * 10 + i;
    }

    public static char lowercaseToUppercase(char character) {
        char b = (char) (character - (char) (32));
        return b;
    }

    public static int fibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static void sortIntegers(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int b = A[i];
                    A[i] = A[j];
                    A[j] = b;
                }
            }
        }
    }

    public static  int strStr(String source, String target) {
        if (target == null || source == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        if(source.length()<target.length()){
            return -1;
        }
        int t = target.length();
        int h = 0;
        for (int i = 0; i < source.length() - t; i++) {
            if (target.equals(source.substring(i, i + t))) {
                h = i;
                break;
            }
        }
        return h;
    }







    public static void main(String[] args) {
        // System.out.println(reverseInteger(900));
        // System.out.println(lowercaseToUppercase('a'));
        // System.out.println(fibonacci(41));
     /*   int A[] = {12, 34, 1, 2, 4, 6, 8};
        sortIntegers(A);
        System.out.println(A.toString());*/
        System.out.println(strStr("abcdabcdefg","bcd"));
    }

}
