package com.data.dataDatail.solutions;

import com.data.dataDatail.array.BinaryNode;
import com.data.dataDatail.array.Node;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: ljh
 * @Date: 2018/12/13 16:58
 * @Description: 在二叉查找树中插入节点
 */
public class solution85 {

    public static Node insertNode(Node root, Node node) {
        // write your code here
        if (root == null) {
            return node;
        }
        if (root.getElement() < node.getElement()) {

            root.setRight(insertNode(root.getRight(), node));

        }
        if (root.getElement() > node.getElement()) {
            root.setLeft(insertNode(root.getLeft(), node));
        }
        return root;
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

        Node Z = new Node(10);

        insertNode(A, Z);
        theFirstTraversal_Stack(A);
    }


    public static void theFirstTraversal_Stack(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                System.out.println(node.getElement());
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                node = node.getRight();
            }
        }

    }


}
