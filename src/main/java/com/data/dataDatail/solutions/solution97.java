package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/17 11:17
 * @Description:
 */
public class solution97 {
      public class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }
      }

    public class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: An integer
         */
        public int maxDepth(TreeNode root) {
            // write your code here
          if(root==null){
              return  0;
          }
          int left = maxDepth(root.left);
          int right = maxDepth(root.right);
          return Math.max(left,right)+1;
        }
    }
}
