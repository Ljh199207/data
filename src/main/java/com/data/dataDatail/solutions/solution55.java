package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/6 15:27
 * @Description: 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母
 */
public class solution55 {

    public static  boolean compareStrings(String A, String B) {
        // write your code here
        int counts[] = new int[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = 0;
        }
        for (int i = 0; i < A.length(); i++) {
            int temp = A.charAt(i) - 'A';
            counts[temp]++;
        }
        for (int i = 0; i < B.length(); i++) {
            int temp = B.charAt(i) - 'A';
            counts[temp]--;
            if (counts[temp] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "ABCD";
        String B = "AABC";
        System.out.println(compareStrings(A,B));
    }
}
