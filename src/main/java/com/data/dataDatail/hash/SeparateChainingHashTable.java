package com.data.dataDatail.hash;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable <AnyType> {

     public SeparateChainingHashTable(){
      this(defalut_table_size);
   }
    public SeparateChainingHashTable(int size){
        thelists = new LinkedList[nextPrime(size)];
        for (int i=0;i<thelists.length;i++)
        {
            thelists[i]= new LinkedList<>();
        }

    }

    public void insert(AnyType x)
    {
        List<AnyType> whichList = thelists[myhash(x)];
        if(!whichList.contains(x))
        {
            whichList.add(x);
            if(++currentSize>thelists.length)
                rehash();
        }
    }
    public void remove(AnyType x)
    {
        List<AnyType> whichList = thelists[myhash(x)];
        if(whichList.contains(x))
        {
            whichList.remove(x);
            currentSize--;
        }
    }


    public boolean contains(AnyType x)
    {
       List<AnyType> whichList = thelists[myhash(x)];

        return  whichList.contains(x);
    }

    public void makeEmpty()
    {
      for(int i =0; i<thelists.length ; i++)
          thelists[i].clear();
          currentSize=0;
    }

        private static final  int defalut_table_size =101;
        private List<AnyType> [] thelists;
        private int currentSize;

        private void rehash(){

        }

        private int myhash(AnyType x)
        {
         int hashVal = x.hashCode();
         hashVal%=thelists.length;
         if(hashVal<0)
             hashVal+=thelists.length;
         return  hashVal;
        }
        private static int nextPrime(int n)
        {
            return 0;
        }
        private static boolean isPrime(int n)
        {
            return true;
        }

}
