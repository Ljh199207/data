package com.data.dataDatail.solutions;

import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/12/17 11:01
 * @Description: 链表划分
 */
public class solution96 {


    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        while (head!=null){
            if(head.val<x)
            {
                left.next=head;
                left=head;
            }
            else
            {
                right.next=head;
                right=head;
            }
            head=head.next;
        }
         right.next=null;
         left.next = rightDummy.next;
         return leftDummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
