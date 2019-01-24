package com.data.mode.factory.simple;

import sun.security.smartcardio.SunPCSC;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:12
 * @Description:
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();
        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();


        FactoryMethod factoryMethod = new FactoryMethod();

        Shape shape = factoryMethod.getCirle();
        shape.draw();



    }
}
