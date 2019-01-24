package com.data.mode.decorator;

import com.data.mode.decorator.abstractClass.Beverage;
import com.data.mode.decorator.abstractClass.CondimentDecorator;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 09:55
 * @Description:
 */
public class Soy extends CondimentDecorator {

    Beverage beverage;
    public Soy(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+", Soy";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
