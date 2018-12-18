package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/3 10:15
 * @Description: 翻转链表
 */
public class solution35 {

    public static void main(String[] args) {

    }



      public ListNode reverse(ListNode head){
          if( head == null || head.next==null){
              return  head;
          }
          ListNode  second = head.next;
          head.next =null;
          ListNode res = reverse(second);
          second.next= head;
          return res;
      }



    public static class ListNode {
        int val;
        ListNode next;

         ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
