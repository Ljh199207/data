package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/7 14:26
 * @Description:
 */
public class solution64 {
    public static void main(String[] args) {
      int A[]={1,2,3};
      int B[]={4,5};
      int m = A.length;
      int n = B.length;
      mergeSortedArray(A,m,B,n);
        System.out.println(A.toString());
    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

 /*     int i = m+n-1;
      int j = m-1;
      int k = n-1;
      while (j>=0 && k>=0){
          if(A[j]>B[k]){
             A[i--] =A[j--];
          }
          else {
              A[i--]=B[k--];
          }
      }
      while (j>=0){
          A[i--]=A[j--];
      }
      while (k>=0){
          A[i--]=B[k--];
      }*/


        int mergeNum = m+n-1;
        int i=m-1,j=n-1;
        while(i>=0 && j>=0){
            if(A[i] > B[j]){
                A[mergeNum--] = A[i--];
            }else{
                A[mergeNum--] = B[j--];
            }
        }
        // while(i >= 0){
        //     A[mergeNum--] = A[i--];
        // }
        while(j >= 0){
            A[mergeNum--] = B[j--];
        }

    }
}
