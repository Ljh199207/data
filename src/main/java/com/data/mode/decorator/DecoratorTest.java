package com.data.mode.decorator;

import com.data.mode.decorator.abstractClass.Beverage;
import com.data.mode.decorator.abstractClass.DarkRoast;
import com.data.mode.decorator.abstractClass.Espresso;

/**
 * @Auther: ljh
 * @Date: 2019/1/18 10:05
 * @Description:
 */
public class DecoratorTest {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription() +" $"+beverage.cost());


        Beverage beverage2 = new DarkRoast();

        beverage2 = new Moca(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() +" $"+beverage2.cost());



    }

}
