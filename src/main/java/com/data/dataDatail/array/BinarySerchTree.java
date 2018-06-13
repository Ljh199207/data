package com.data.dataDatail.array;

import java.nio.BufferUnderflowException;

public class BinarySerchTree<AnyType extends  Comparable<? super AnyType>> {


    private static  class BinaryNode<AnyType>
    {
        AnyType element;
        private BinaryNode<AnyType> left ;
        private BinaryNode<AnyType> right ;

        public BinaryNode(AnyType theElement)
        {
            this(theElement,null,null);
        }
        public BinaryNode(AnyType theElement,BinaryNode<AnyType>lt,BinaryNode<AnyType>rt)
        {
            element=theElement;
            left=lt;
            right=rt;
        }
    }

    private  BinaryNode<AnyType> root;

    public BinarySerchTree()
    {
        root=null;
    }
    public void makeEmpty()
    {
        root=null;
    }

    public boolean isEmpty()
    {
        return root==null;
    }

    public boolean contains(AnyType x)
    {
        return contains(x,root);
    }
    public boolean contains(AnyType x,BinaryNode<AnyType> t)
    {
        if(t==null)
            return  false;
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0)
        {
            return contains(x,t.left);
        }
        else if(compareResult > 0)
        {
            return contains(x,t.right);
        }
        else
        {
            return true;
        }
    }

    public AnyType findMin()
    {
      if(isEmpty()) throw   new BufferUnderflowException();
      return  findMin(root).element;
    }

    private  BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
    {
     if(t==null)
         return  null;
     else if(t.left==null)
         return t;
     return findMin(t.left);
    }

    public AnyType findMax()
    {
        if(isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }
    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> t)
    {
        if(t==null)
            return null;
        if(t.right==null)
            return  t;
        return  findMax(t.right);

    }

}
