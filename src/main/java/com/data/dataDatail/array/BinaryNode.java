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

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode<AnyType> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<AnyType> left) {
        this.left = left;
    }

    public BinaryNode<AnyType> getRight() {
        return right;
    }

    public void setRight(BinaryNode<AnyType> right) {
        this.right = right;
    }
}
