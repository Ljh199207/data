package com.data.mode.factory.staticfactor;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:37
 * @Description:
 */
public class Blue implements  Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
