package com.data.dataDatail.heap;

import org.omg.CORBA.Any;

public class leftHeap<AnyType extends Comparable<? super   AnyType>> {

   private Node<AnyType> root;
   public  leftHeap(){
       root=null;
   }

   public void merge(leftHeap<AnyType> rhs)
   {
       if(rhs==null) return;
       root= merge(root,rhs.root);
       rhs.root=null;
   }
   private Node<AnyType> merge(Node<AnyType> h1,Node<AnyType> h2){
     if(h1==null) return  h2;
     if(h2==null) return  h1;
     if(h1.element.compareTo(h2.element)<0)
         return merge1(h1,h2);
     else
         return  merge1(h2,h1);
   }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
       if(h1.left==null) h1.left=h2;
       else
       {
           h1.right = merge(h1.right,h2);
           if(h1.left.npl<h1.right.npl)
               swapChild(h1);
           h1.npl=h1.right.npl+1;
       }
       return h1;
    }

    private void swapChild(Node<AnyType> h1) {
        Node<AnyType> temp = h1.right;
        h1.right=h1.left;
        h1.left= temp;
    }

    public void insert(AnyType x){

        root= merge(root,new Node<>(x));
   }
   public AnyType findMin(){
       if(isEmpty()){
           System.out.println("该左式堆为空");
       }
       return root.element;
   }
   public AnyType deleteMin()
   {
       if (isEmpty()) {
           System.out.println("该左式堆为空");
       }

       AnyType minElement = root.element;
       root=merge(root.left, root.right);
       return minElement;
   }
    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 置空
     */
    public void makeEmpty() {
        this.root = null;
    }

    private void print(Node t){
        if(t==null)
            return;

        print(t.left);
        print(t.right);
        System.out.println(t.element+":"+t.npl);
    }

    public static  class  Node<AnyType>
    {
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;
        public  Node(AnyType theElement){
          this(theElement,null,null);
        }
        public  Node(AnyType theElement,Node<AnyType> lt,Node<AnyType> rt){
           element=theElement; left =lt; right = rt; npl= 0;
        }
    }

    public static void main(String[] args) {

        int numItems = 100;
        leftHeap<Integer> h  = new leftHeap<>( );
        leftHeap<Integer> h1 = new leftHeap<>( );
        int i = 37;
        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            if( i % 2 == 0 )
                h1.insert( i );
            else
                h.insert( i );
        h.merge( h1 );
   /*     h.print(h.root);*/
        /*for( i = 1; i < numItems; i++ )
            if( h.deleteMin() != i )
                System.out.println( h.deleteMin( )   + "Oops! " + i );*/

        leftHeap<Integer> h2  = new leftHeap<>( );
        leftHeap<Integer> h3 = new leftHeap<>( );
        h2.insert( 3 );
        h2.insert( 10 );
        h2.insert( 8 );
        h2.insert( 21 );
        h2.insert( 14 );
        h2.insert( 14 );
        h2.insert( 23 );
        h2.insert( 26 );

        h3.insert( 6 );
        h3.insert( 12 );
        h3.insert( 7 );
        h3.insert( 18 );
        h3.insert( 24 );
        h3.insert( 37 );
        h3.insert( 18 );
        h3.insert( 33 );
        h2.merge( h3 );
        h2.print(h2.root);
    }

}
