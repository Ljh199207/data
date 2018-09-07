package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/8/24 16:17
 * @Description:
 */
public class 字符串查找 {


    public static void main(String[] args) {



    }



    public static void getNext(char[] p,int next[]){

        int q ,k;//q就模版字符下标，k是最大后缀长度
        int m = p.length;
        next[0]=0;
        for(q=1,k=0;q<m;++q){
           while(k>0&&p[q]!=p[k])
               k=next[k-1];
           if(p[q]==p[k])
               k++;
            next[q]=k;
        }

    }



    public static  int bf(String a,String b){
       char [] t = a.toCharArray();
       char [] p = b.toCharArray();
       int i = 0;  //主串
       int j = 0;  //模式串位置
         while (i < t.length && j < p.length){
             if(t[i]==p[j]){
                 i++;
                 j++;
             }
             else{
                i=i-j+1;
                 j=0;
             }
         }
        if(j==p.length){
            return i - j;
        }
        else{
            return -1;
        }
    }
}
