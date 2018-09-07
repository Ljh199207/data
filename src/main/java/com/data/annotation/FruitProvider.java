package com.data.annotation;

import java.lang.annotation.*;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 10:35
 * @Description:
 */
@Target(ElementType.FIELD)
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProvider {
    /**
     * 供应商编号
     */
    public int id() default -1;

    /**
     * 供应商名称
     */
    public String name() default "";

    /**
     * 供应商地址
     */
    public String address() default "";
}
