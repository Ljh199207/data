package com.data.mode.decorator;

import com.data.mode.decorator.abstractClass.Beverage;
import com.data.mode.decorator.abstractClass.CondimentDecorator;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:55
 * @Description:
 */
public class Moca extends CondimentDecorator {

    Beverage beverage;
    public  Moca(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+", Moca";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
