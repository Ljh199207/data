package com.data.dataDatail.array;


import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount=0;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;

    private static class Node<AnyType>{

        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
        public  Node(AnyType d,Node<AnyType> p,Node<AnyType> n)
        {
          data =d;
          prev=p;
          next=n;
        }
    }
    public MyLinkedList(){
        doClear();
    }
    private void doClear() {
        beginMaker = new Node<AnyType>(null,null,null);
        endMaker = new Node<AnyType>(null,beginMaker,null);
        beginMaker.next=endMaker;
        theSize=0;
        modCount++;
    }
    public void clear()
    {
        doClear();
    }
    public int size()
    {
        return theSize;
    }
    public boolean inEmpty()
    {
        return size()==0;
    }
    public boolean add(AnyType x)
    {
        add(size(),x);
        return  true;
    }
    public void add(int idx, AnyType x) {
        addBefore(getNode(idx,0,size()),x);
    }
    public AnyType get(int index)
    {
      return getNode(index).data;
    }
    public  AnyType set(int index,AnyType val){
      Node<AnyType> p = getNode(index);
      AnyType oldVal = p.data;
      p.data=val;
      return oldVal;
    }
    private void addBefore(Node<AnyType> node, AnyType x) {
        Node<AnyType> newNode = new Node<>(x,node.prev,node);
        newNode.prev.next =newNode;
        node.prev=newNode;
        theSize++;
        modCount++;
    }
    private Node<AnyType> getNode(int idx, int lower, int upper) {
      Node<AnyType> p;
      if(idx<lower||idx>upper)
          throw  new IndexOutOfBoundsException();
      if(idx<size()/2){
          p=beginMaker.next;
          for (int i =0;i<idx;i++)
              p=p.next;
      }
      else
      {
          p=endMaker;
          for (int i =size();i>idx;i--)
          {
              p=p.prev;
          }
      }
      return  p;
    }
    private Node<AnyType> getNode(int idx) {
       return getNode(idx,0,size()-1);
    }
    public AnyType remove(int index)
    {
        return remove(getNode(index));
    }
    private  AnyType remove(Node<AnyType> p)
    {
      p.next.prev=p.prev;
      p.prev.next=p.next;
      theSize--;
      modCount++;
      return p.data;
    }
    @Override
    public Iterator<AnyType> iterator() {
        return new MyLinkedListIterator<>();
    }
    private  class MyLinkedListIterator<AnyType> implements  Iterator<AnyType>
    {
        private Node currentNode = beginMaker.next;
        private int nextIndex = 0;
        @Override
        public boolean hasNext() {
           return nextIndex!=size();
        }
        @Override
        public AnyType next() {
            AnyType data = (AnyType) currentNode.data;
            currentNode= currentNode.next;
            nextIndex++;
            return data;
        }
    }

}
