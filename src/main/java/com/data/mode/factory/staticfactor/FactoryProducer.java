package com.data.mode.factory.staticfactor;

/**
 * @Auther: ljh
 * @Date: 2019/1/21 10:49
 * @Description:
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice ){
       if(choice.equalsIgnoreCase("shape")){
           return new ShapeFactory();
       }
       else if(choice.equalsIgnoreCase("color")){
           return  new ColorFactory();
       }
       return null;
    }
}
