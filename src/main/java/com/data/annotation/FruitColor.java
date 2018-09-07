package com.data.annotation;

import java.lang.annotation.*;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 10:33
 * @Description: 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color{BLUE,RED,GREEN};

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;
}
