package com.data.dataDatail.array;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<Object> {

    private  final  static  int DEFAULT_CAPACITY = 10 ;

    private int theSize;

    private AnyType[] theItems ;


   public MyArrayList()
   {
       doClear();
   }

    public void clear()
    {
        doClear();
    }
    public boolean isEmpty()
    {
        return  size()==0;
    }
    public void trimToSize(){
       ensureCapacity(size());
    }
    public void doClear(){
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    public int size()
    {
        return  theSize;
    }
    public AnyType get(int index)
    {
        if(index<0 ||index >=size())
        throw new ArrayIndexOutOfBoundsException();
        return theItems[index];
    }
    public AnyType set(int index,AnyType anyType)
    {
        if(index<0 ||index >=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old = theItems[index];
        theItems[index]=anyType;
        return old;
    }
    public void ensureCapacity(int newCapacity){
        if(newCapacity<theSize)
            return;
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for(int i =0;i<size();i++)
        {
            theItems[i]=old[i];
        }
    }
    public boolean add(AnyType T)
    {
        add(size(),T);
        return true ;
    }
    public  void  add(int index, AnyType anyType)
    {
        if(theItems.length ==size())
            ensureCapacity(size()*2+1);
        for(int i =theSize;i>index;i--)
            theItems[i]=theItems[i-1];
        theItems[index]=anyType;
        theSize++;
    }

    public AnyType remove(int index)
    {
        AnyType re = theItems[index];
        for(int i = index;i<size()-1;i++)
        theItems[i]=theItems[i+1];
        theSize--;
        return re;
    }

    @Override
    public Iterator iterator() {
       return new ArrayListIterator();
    }

    public Iterator iterator2(MyArrayList<AnyType> anyType)
    {
        return new ArrayListIterator2(anyType);

    }

    /**
     *
     */
    private class ArrayListIterator implements Iterator<AnyType>
    {
        private  int current=0;

        @Override
        public boolean hasNext() {
            if(current >= size()) return false;
            else return true;
        }

        @Override
        public AnyType next() {
            if(!hasNext())
                throw new NoSuchElementException();
             return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    /**
     *
     */
    private class ArrayListIterator2 implements Iterator<AnyType>
    {
        private  int current = 0;
        private MyArrayList<AnyType> theList;

        public ArrayListIterator2(MyArrayList<AnyType> list)
        {
            theList=list;
        }

        @Override
        public boolean hasNext() {
            return current<theList.size();
        }

        @Override
        public AnyType next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return theList.theItems[current++];
        }
        @Override
        public void remove() {
            theList.remove(--current);
        }

    }






    public  void printof()
    {
        for (int i =0;i<size();i++)
        {
            System.out.print(theItems[i].toString());
        }
    }
}
