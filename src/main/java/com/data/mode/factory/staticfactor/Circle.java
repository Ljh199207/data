package com.data.mode.factory.staticfactor;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:06
 * @Description:
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
