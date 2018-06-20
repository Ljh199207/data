package com.data.dataDatail.array;

import org.omg.CORBA.Any;

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

    public void insert(AnyType x)
    {
     root =insert(x,root);
    }
    public void remove(AnyType x)
    {
     root = remove(x,root);
    }

    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t)
    {
      if(t==null)
          return  new BinaryNode<>(x,null,null);
      int compareResult = x.compareTo(t.element);
      if(compareResult<0)
          t.left= insert(x,t.left);
      if(compareResult>0)
          t.right=insert(x,t.right);
      else
          ; //do nothing;
          return t;
    }

    private  BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t)
    {
        if(t==null)
            return t ;
        int compareResult = x.compareTo(t.element);
        if(compareResult<0)
              t.left=remove(x,t.left);
        else if(compareResult>0)
            t.right= remove(x,t.right);
        else if(t.right!=null&&t.left!=null)
        {
            t.element=findMin(t.right).element;
            t.right=remove(t.element,t.right);
        }
        else
            t=(t.left!=null)?t.left:t.right;
         return t;

    }

    public  void printTree()
    {
        if(isEmpty())
            System.out.println("Empty Tree");
        else
            printTree(root);
    }

    private void printTree(BinaryNode<AnyType> root) {
        if(root!=null)
        {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }

    }



}
