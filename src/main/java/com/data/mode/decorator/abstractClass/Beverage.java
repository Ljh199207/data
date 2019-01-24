package com.data.mode.decorator.abstractClass;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:30
 * @Description:   对象
 */
public abstract class Beverage {

    String description ="Unknown Beverage";

    public String getDescription(){
      return  description ;
    }

    public abstract  double cost();

}
