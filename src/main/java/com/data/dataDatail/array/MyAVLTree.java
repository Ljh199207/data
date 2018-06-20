package com.data.dataDatail.array;

public class MyAVLTree<E extends Comparable<E>> {

    private static class AvlNode<E> {
        E element;
        AvlNode<E> left;
        AvlNode<E> right;
        int height;

        public AvlNode(E element) {
            this(element, null, null);
        }

        public AvlNode(E element, AvlNode<E> left, AvlNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private AvlNode<E> root;

    public MyAVLTree() {
        this.root = null;
    }

    public void insert(E x) {
        root = insert(x, root);
    }

    public void remove(E x) {
        remove(x, root);
    }

    public int height() {
        return height(root);
    }

    private int height(AvlNode<E> node) {
        return node == null ? -1 : node.height;
    }

    private AvlNode<E> insert(E x, AvlNode<E> t) {
        if (t == null) {
            return new AvlNode<>(x);
        }
        int compareResult = x.compareTo(t.element);
        //插到左子树上
        if (compareResult < 0) {
            t.left = insert(x, t.left);
            //插入之后要判断是否打破了平衡，因为插入的是左子树，
            // 只有左子树才会打破平衡，用左子树的高减去右子树的高
            if (height(t.left) - height(t.right) == 2) {
                if (x.compareTo(t.left.element) < 0) {
                    //如果x小于t的左子树的值，那么x会被插到t的左子树的左子树上，符合LL 用右旋转调整。
                    t = rightRotate(t);
                } else {
                    //如果x大于t的左子树的值，则会被插到t的左子树的右子树上，符合LR，用先左旋转后右旋转来矫正。
                    t = leftAndRightRotate(t);
                }
            }
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (x.compareTo(t.right.element) > 0) {
                    t = leftRotate(t);
                } else {
                    t = rightAndLeftRotate(t);
                }
            }
        } else {
            //已经有这个值了
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<E> remove(E x, AvlNode<E> t) {
        if (t == null) {
            return null;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
            if (t.right != null)  //若右子树为空，则一定是平衡的，此时左子树相当对父节点深度最多为1, 所以只考虑右子树非空情况
            {
                if (t.left == null) {  //若左子树删除后为空，则需要判断右子树
                    if (height(t.right) - t.height == 2) {
                        AvlNode<E> k = t.right;
                        if (k.right != null)    //右子树存在，按正常情况单旋转
                            t = leftRotate(t);
                        else
                            t = rightAndLeftRotate(t);
                    }
                }
            }
            if (t.left != null)  //否则判断左右子树的高度差
            {
                //左子树自身也可能不平衡，故先平衡左子树，再考虑整体
                AvlNode<E> k = t.left;
                //删除操作默认用右子树上最小节点补删除的节点
                //k的左子树高度不低于k的右子树
                if (k.right != null) {
                    if (height(k.left) - height(k.right) == 2) {
                        AvlNode<E> m = k.left;
                        if (m != null)
                            k = rightRotate(t);
                        else
                            k = leftAndRightRotate(k);
                    }
                }
                else
                {
                  if(height(k.left)-k.height==2)
                  {
                      AvlNode<E> m = k.left;
                      if(m.left!=null)
                      {
                          k=rightRotate(k);
                      }
                      else
                      {
                          k=leftAndRightRotate(k);
                      }
                  }
                }
                if (height(t.right) - height(t.left) == 2) {
                    //右子树自身一定是平衡的，左右失衡的话单旋转可以解决问题
                    t = leftRotate(t);
                }
            }
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        }

        else if(compareResult>0)
        {



        }
        return t;
    }

    private AvlNode<E> rightRotate(AvlNode<E> t) {
        AvlNode newTree = t.left;
        t.left = newTree.right;
        newTree.right = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;
        return newTree;
    }

    private AvlNode<E> leftRotate(AvlNode<E> t) {
        AvlNode newTree = t.right;
        t.right = newTree.right;
        newTree.left = t;
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;
        return newTree;
    }

    private AvlNode<E> leftAndRightRotate(AvlNode<E> t) {
        t.left = leftRotate(t.left);
        return rightRotate(t);
    }

    private AvlNode<E> rightAndLeftRotate(AvlNode<E> t) {
        t.right = rightRotate(t.right);
        return leftRotate(t);
    }
}


