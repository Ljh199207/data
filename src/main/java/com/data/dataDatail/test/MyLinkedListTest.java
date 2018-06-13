package com.data.dataDatail.test;
import com.data.dataDatail.array.MyLinkedList;
import java.util.Iterator;
public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList my = new MyLinkedList();
        my.add(1);
        my.add(2);
        my.add(3);
        my.add(4);
        my.add(5);
        my.add(6);
        my.add(7);
        my.add(8);
        my.add(9);
        my.add(10);
        my.add(3,11);
        my.remove(1);
        my.remove(5);
        System.out.println(my.size());
        Iterator s = my.iterator();
        while (s.hasNext())
        {
            Object o = s.next();
            System.out.println("++"+o);
        }
    }
}
