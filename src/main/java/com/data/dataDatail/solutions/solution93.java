package com.data.dataDatail.solutions;


import com.data.dataDatail.array.Node;

/**
 * @Auther: ljh
 * @Date: 2018/12/17 09:51
 * @Description:   平衡二×树
 */
public class solution93 {


    public static boolean isBalanced(Node root) {
        // write your code here
        return isSubTreeBalanced(root) != -1;
    }

    public static  int isSubTreeBalanced(Node root){
        if(root==null){
            return 0;
        }
        int left = isSubTreeBalanced(root.getLeft());
        int right = isSubTreeBalanced(root.getRight());

        if(left == -1 ||right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        else {
            return (left>right?left:right)+1;
        }

    }

    public static void main(String[] args) {
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        System.out.println(isBalanced(A));
    }
}
