package com.data.dataDatail.algorithm;

public   class insertSort <AnyType extends Comparable<? super   AnyType>> {
    //自己写的
    public static void inserSort2(int [] A){
        for(int i=1;i<A.length;i++){
            for(int j =0;j<i;j++){
                while (A[i]<A[j]){
                    int b = A[i];
                    A[i]=A[j];
                    A[j]=b;
                }
            }

        }

    }
    //网上的

    public static void inserSort3(int [] arr){
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            target = arr[i];

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }

    }

    public void  inserSort4(AnyType[] arr){
     int j ;
     for(int i =1;i<arr.length;i++)
     {
         AnyType tem = arr[i];
         for(j=i;tem.compareTo(arr[j-1])<0;j--){
            arr[j]=arr[j-1];
         }
         arr[j]=tem;


     }
    }

    public static void main(String[] args) {
        int A[] ={5,2,4,6,1,3};
        inserSort3(A);
        for(int i =0;i<A.length;i++)
            System.out.println(A[i]);
    }

}
