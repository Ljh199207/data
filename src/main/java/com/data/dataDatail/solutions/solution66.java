package com.data.dataDatail.solutions;

import com.data.dataDatail.array.BinaryNode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: ljh
 * @Date: 2018/12/7 15:09
 * @Description: 二叉树的前序遍历
 */
public class solution66 {
    public BinaryNode init() {
        //注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
        BinaryNode J = new BinaryNode(8, null, null);
        BinaryNode H = new BinaryNode(4, null, null);
        BinaryNode G = new BinaryNode(2, null, null);
        BinaryNode F = new BinaryNode(7, null, J);
        BinaryNode E = new BinaryNode(5, H, null);
        BinaryNode D = new BinaryNode(1, null, G);
        BinaryNode C = new BinaryNode(9, F, null);
        BinaryNode B = new BinaryNode(3, D, E);
        BinaryNode A = new BinaryNode(6, B, C);
        return A;   //返回根节点
    }

    public static void theFirstTraversal_Stack(BinaryNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<BinaryNode>  stack = new Stack<BinaryNode>();
        BinaryNode binaryNode = root;
        while (binaryNode!=null||stack.size()>0){
             if(binaryNode!=null){
                 System.out.println(binaryNode.getElement());
                 stack.push(binaryNode);
                 binaryNode=binaryNode.getLeft();
             }
             else {
                 binaryNode= stack.pop();
                 binaryNode = binaryNode.getRight();
             }
        }

    }

    public static List<Integer> postorderTraversal(BinaryNode root) {
        // write your code here
        List<Object> list = new ArrayList<Object>();
        Stack<BinaryNode>  stack = new Stack<BinaryNode>();
        Stack<Integer>  stack1 = new Stack<Integer>();
        BinaryNode binaryNode = root;
        while (binaryNode!=null||stack.size()>0){
            while(binaryNode!=null ){
                stack.push(binaryNode);
                stack1.push(0);
                binaryNode=binaryNode.getLeft();
            }
            if(!stack.isEmpty()){
                stack1.pop();
                stack1.push(1);
                binaryNode =stack.peek();
                binaryNode=binaryNode.getRight();
            }
            while (!stack.isEmpty()&&stack1.peek()==1){
                stack1.pop();
              //  list.add(stack.pop().getElement());
                System.out.println( stack.pop().getElement());
            }
        }
      return  null;
    }






    public  static void  levelOrder(BinaryNode root) {
        // write your code here
       if(root==null){
           return;
       }
        LinkedList<BinaryNode> quene = new LinkedList<BinaryNode>();
        List<List<Object>> lists = new ArrayList<List<Object>>();
        BinaryNode current = null;
        quene.offer(root);//将根节点入队
        while (!quene.isEmpty()){
            int count = quene.size();
            System.out.print(count+"--");
            List<Object> list = new ArrayList<>();
            while (count>0){
                current= quene.poll();
                list.add(current.getElement());
                System.out.println(current.getElement());
                if(current.getLeft()!=null){
                    quene.offer(current.getLeft());
                }
                if(current.getRight()!=null){
                    quene.offer(current.getRight());
                }
                count--;
            }

            lists.add(list);
        }



    }

        public static void main(String[] args) {
            BinaryNode J = new BinaryNode(8, null, null);
            BinaryNode H = new BinaryNode(4, null, null);
            BinaryNode G = new BinaryNode(2, null, null);
            BinaryNode F = new BinaryNode(7, null, J);
            BinaryNode E = new BinaryNode(5, H, null);
            BinaryNode D = new BinaryNode(1, null, G);
            BinaryNode C = new BinaryNode(9, F, null);
            BinaryNode B = new BinaryNode(3, D, E);
            BinaryNode A = new BinaryNode(6, B, C);
           // theFirstTraversal_Stack(A);
            //后序
          //  postorderTraversal(A);
            //层序
            levelOrder(A);
    }


}
