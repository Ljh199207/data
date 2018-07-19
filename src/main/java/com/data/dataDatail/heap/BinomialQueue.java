package com.data.dataDatail.heap;

public class BinomialQueue<T extends Comparable> {
    /**
     * 二项树 采取左儿子右兄弟的记录方式
     */
    static class BinNode<T> {
        private T element;//元素
        private BinNode<T> leftChild;//左二子
        private BinNode<T> nextSibling;//兄弟

        public BinNode(T element) {
            this(element, null, null);
        }

        public BinNode(T element, BinNode<T> lt, BinNode<T> ns) {
            this.element = element;
            this.leftChild = lt;
            this.nextSibling = ns;
        }
    }

    private static  final  int DEAFULT_TREES =1;//默认二项树的个数
    private int currentSize;//数组内的元素
    private BinNode<T>[] arrayTrees;//存放二项树的数组
    /**
     * 构造器
     */
    public BinomialQueue() {
        arrayTrees = new BinNode[DEAFULT_TREES];
    }

    public BinomialQueue(T x) {
        currentSize = 1;
        arrayTrees = new BinNode[1];
        arrayTrees[0] = new BinNode<>(x);
    }

    public boolean isEmpty()
    {
        return currentSize==0;
    }

    public void makeEmpty(){
        this.currentSize=0;
        for (BinNode bn : arrayTrees) {
            bn = null;
        }

    }

    public void merge(BinomialQueue rhs){
        if(this == rhs) return;
        currentSize += rhs.currentSize;
        if(currentSize>=capacity())
        {
            int newNumTrees = Math.max(this.arrayTrees.length, rhs.arrayTrees.length) + 1;
            expandTheTrees(newNumTrees);
        }
        BinNode<T> carry = null;
        for (int i = 0, j = 1; j <= currentSize; i++, j *= 2) {//使用j来控制是否结束
            BinNode<T> t1 = arrayTrees[i];//this二项树
            BinNode<T> t2 = i < rhs.arrayTrees.length ? rhs.arrayTrees[i] : null;//rhs二项树
            int whichCase = (t1 == null ? 0 : 1);
            whichCase += (t2 == null ? 0 : 2);
            whichCase += (carry == null ? 0 : 4);
            switch (whichCase)
            {
                case 0://this,rhs,carry都为空
                    break;
                case 1://只有this二项树
                    break;
                case 2://只有rhs二项树
                    arrayTrees[i] = t2;
                    rhs.arrayTrees[i] = null;
                    break;
                case 3://只有rhs和this二项树
                    carry = combinTrees(t1, t2);//二项树升级,不放在本节点，放在carry等待处理下个节点时处理
                    this.arrayTrees[i] = rhs.arrayTrees[i] = null;
                    break;
                case 4://只有carry二项树
                    this.arrayTrees[i] = carry;
                    carry = null;
                    break;
                case 5://只有carry和this二项树
                    carry = combinTrees(t1, carry);
                    this.arrayTrees[i] = null;
                    break;
                case 6://只有carry和rhs二项树
                    carry = combinTrees(t2, carry);
                    rhs.arrayTrees[i] = null;
                    break;
                case 7://有this,rhs和carry二项树
                    this.arrayTrees[i] = carry;
                    carry = combinTrees(t1, t2);
                    rhs.arrayTrees[i] = null;
                    break;
            }
        }
    }

    private BinNode<T> combinTrees(BinNode<T> t1, BinNode<T> t2) {
        if (t1.element.compareTo(t2.element) > 0)
            return combinTrees(t2, t1);
        t2.nextSibling = t1.leftChild;
        t1.leftChild = t2;
        return t1;
    }

    private void expandTheTrees(int newNumTrees) {
        BinNode<T>[] newTrees = new BinNode[newNumTrees];
        for (int i = 0; i < Math.min(arrayTrees.length, newNumTrees); i++) {
            newTrees[i] = arrayTrees[i];
        }
        arrayTrees = newTrees;
    }

    /**
     * 容量(该二项队列最大容量 2^k-1 k为数组长度)
     *
     * @return
     */
    private int capacity() {
        return (1 << arrayTrees.length) - 1;
    }
}
