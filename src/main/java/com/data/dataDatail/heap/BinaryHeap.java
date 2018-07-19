package com.data.dataDatail.heap;

import org.omg.CORBA.Any;

//二×堆
public class BinaryHeap<AnyType extends Comparable<? super   AnyType>> {

    private  static final int DEFAULT_CAPATITY =10;
    public int currentSize;
    public AnyType [] array;
    public BinaryHeap(){
        this( DEFAULT_CAPATITY );
    }
    //初始化
    public  BinaryHeap(int capacity){
        currentSize =0;
        array=(AnyType[])new Comparable[capacity+1];

    }
    public BinaryHeap(AnyType [] item){
        currentSize=item.length;
        array=(AnyType[])new Comparable[(currentSize+2)*11/10];
        int i=1;
        for(AnyType it :item)
            array[i++]=it;
        buildHeap();
    }
    //逐层下滤
    private void buildHeap() {
        for(int i=currentSize/2;i>0;i--)
            percolateDown(i);
    }

    private void percolateDown(int i) {
         int child ;
        AnyType tmp = array[ i ];
        for( ; i * 2 <= currentSize; i = child )
        {
            child = i * 2;
            if(child!=currentSize && array[ child + 1 ].compareTo( array[ child ] ) < 0)
            {
                child++;
            }
            if(array[ child ].compareTo( tmp ) < 0)
            {
                array[ i ] = array[ child ];
            }
            else
                break;
        }
        array[ i ] = tmp;
    }

    public  void insert(AnyType item){
        if(currentSize ==array.length-1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        for( array[ 0 ] = item; item.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )

            array[ hole ] = array[ hole / 2 ];

            array[ hole ] = item;

    }

    private void enlargeArray(int i) {
        AnyType [] old = array;
        array = (AnyType []) new Comparable[ i ];
        for(int j = 0; j < old.length; j++)
        {
            array[ j ] = old[ j ];
        }
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }
    public void makeEmpty()
    {
        currentSize =0;
    }
    public AnyType  deleteMin(int i){
        AnyType minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );
        return minItem;
    }
    public AnyType findMin(){
        if (isEmpty())
            return  null;
        return array[1];
    }


    public static void main(String[] args) {

      /*  int numItems = 10000;
        BinaryHeap<Integer>  binaryHeap = new BinaryHeap();
        int i = 37;
        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            binaryHeap.insert( i );
        Object [] a = binaryHeap.array;
        for(int j =0;j<a.length;j++)
            System.out.println(a[j].toString());
        */

        Integer []A = {152,141,415,10,100,120,110};
        BinaryHeap<Integer>  binaryHeap2 = new BinaryHeap(A);
        Object [] b= binaryHeap2.array;
        for(int j =1;j<b.length;j++)
        System.out.println(b[j].toString());
    }

}
