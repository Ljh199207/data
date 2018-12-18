package com.data.dataDatail.array;

/**
 * @Auther: ljh
 * @Date: 2018/12/13 17:04
 * @Description:
 */
public class Node <AnyType> {

    int element;
    private Node<AnyType> left ;
    private Node<AnyType> right ;

    public Node(int val){
        this.element=val;
        this.left=this.right=null;
    }
    public Node(int element,Node left,Node right){
        this.element=element;
        this.left=left;
        this.right=right;
    }
    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node<AnyType> getLeft() {
        return left;
    }

    public void setLeft(Node<AnyType> left) {
        this.left = left;
    }

    public Node<AnyType> getRight() {
        return right;
    }

    public void setRight(Node<AnyType> right) {
        this.right = right;
    }
}
