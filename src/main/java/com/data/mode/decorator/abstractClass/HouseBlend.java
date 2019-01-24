package com.data.mode.decorator.abstractClass;

import com.data.mode.decorator.abstractClass.Beverage;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:42
 * @Description:
 */
public class HouseBlend extends Beverage {

    public  HouseBlend(){
        description ="House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
