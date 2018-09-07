package com.data.annotation;

import java.lang.annotation.*;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 10:30
 * @Description: 水果名称注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FruitName {
    String value() default "";
}
