package com.data.dataDatail.array;

public    class BinaryNode<AnyType>{

    Object element;
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
