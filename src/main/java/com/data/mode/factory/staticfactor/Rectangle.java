package com.data.mode.factory.staticfactor;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:05
 * @Description:
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
