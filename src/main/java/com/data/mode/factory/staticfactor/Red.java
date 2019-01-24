package com.data.mode.factory.staticfactor;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:36
 * @Description:
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
