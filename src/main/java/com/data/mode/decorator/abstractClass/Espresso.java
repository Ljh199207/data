package com.data.mode.decorator.abstractClass;

import com.data.mode.decorator.abstractClass.Beverage;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:40
 * @Description:
 */
public class Espresso extends Beverage {

    public  Espresso(){
        description="Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
