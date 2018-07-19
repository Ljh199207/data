package com.data.dataDatail.heap;

//二项堆
public class BinomialHeap<T extends Comparable<T>> {


    private BinomialNode<T> mRoot;

    public class BinomialNode<T extends Comparable<T>> {
        T key;                   // 关键字(键值)
        int degree;              // 度数
        BinomialNode<T> child;   //左孩子
        BinomialNode<T> parent;  // 父节点
        BinomialNode<T> next;    // 兄弟节点

        public BinomialNode(T key) {
            this.key = key;
            this.degree = 0;
            this.child = null;
            this.parent = null;
            this.next = null;
        }
        public String toString() {
            return "key:"+key;
        }
    }


    private BinomialNode<T> merge(BinomialNode<T> h1,BinomialNode<T> h2)
    {
        if(h1==null) return h2;
        if(h2==null) return h1;
        // root是新堆的根，h3用来遍历h1和h3的。
        BinomialNode<T> pre_h3, h3, root=null;
        pre_h3 = null;
        //整个while，h1, h2, pre_h3, h3都在往后顺移
        while ((h1!=null) && (h2!=null)){
            if(h1.degree<=h2.degree){
                h3 = h1;
                h1 = h1.next;
            }
            else
            {
                h3=h2;
                h2=h2.next;
            }

            if (pre_h3 == null) {
                pre_h3 = h3;
                root = h3;
            } else {
                pre_h3.next = h3;
                pre_h3 = h3;
            }
            if (h1 != null) {
                h3.next = h1;
            } else {
                h3.next = h2;
            }
        }

        return root;
    }
}

