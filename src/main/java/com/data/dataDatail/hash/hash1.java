package com.data.dataDatail.hash;

public class hash1 {

    //表过大会出现分配不均匀的情况下。
    public static  int hash2(String key ,int tableSize)
    {
        int hashVal =0;
        for(int i = 0; i < key.length();i++)
        {
            hashVal+=key.charAt(i);

        }
        return hashVal % tableSize;
    }

    //涉及到至少3个字符。也为会出现分配不均的情况
    public static int hash3(String key,int tableSize)
    {
          int hashVal = 0;

          return (key.charAt(0)+27*key.charAt(1)+729*key.charAt(2))%tableSize;
    }
    //常用的算法
    public static int hash4(String key,int tableSize)
    {
        int hashVal = 0;
        for(int i =0;i<key.length();i++)
            hashVal=37*hashVal+key.charAt(i);
        hashVal=hashVal%tableSize;
        if(hashVal<0)
            hashVal+=tableSize;
        return hashVal;
    }


}
