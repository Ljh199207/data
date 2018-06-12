package com.data.dataDatail.test;

import com.data.dataDatail.array.MyArrayList;

import java.util.Iterator;

public class MyArrayListTest {

    public static void main(String[] args) {

        MyArrayList my = new MyArrayList();
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
        my.printof();
        System.out.println();
        my.remove(1);
        my.printof();
        System.out.println();

        my.add(2,10);
        my.printof();
        Iterator it = my.iterator();
        while (it.hasNext())
        {
            Object s = it.next();
            System.out.println("+++++"+s.toString());

        }

        Iterator it2 = my.iterator2(my);
        while (it2.hasNext())
        {
            Object s = it2.next();
            System.out.println("1+++++"+s.toString());

        }

        my.clear();
        my.printof();



    }

}
