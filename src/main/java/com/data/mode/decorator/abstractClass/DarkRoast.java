package com.data.mode.decorator.abstractClass;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:40
 * @Description:
 */
public class DarkRoast extends Beverage {

    public DarkRoast(){
        description="DarkRoast";
    }

    @Override
    public double cost() {
        return 2.99;
    }
}
