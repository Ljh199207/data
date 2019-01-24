package com.data.mode.factory.simple;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:21
 * @Description:
 */
public class FactoryMethod {

    public Shape getRetangle() {
        return new Rectangle();
    }

    public Shape getSquare() {
        return new Square();
    }

    public Shape getCirle() {
        return new Circle();
    }
}
