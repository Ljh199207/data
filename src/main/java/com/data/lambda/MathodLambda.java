package com.data.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: ljh
 * @Date: 2018/9/11 09:32
 * @Description:
 */
public class MathodLambda {

    public static String put() {
        return "hello";
    }

    public static void set(int size) {
        System.out.println("静态方法 有参数 ");
    }

    public static String toUpperCase(String string){
        return  string.toUpperCase();
    }

    public static Integer len(String s1,String s2){
        return s1.length()+s2.length();
    }
    public static void main(String[] args) {

        /**
         *
         * 功能描述: 静态方法引用    无参有输出
         *
         */
        Supplier<String> s1 = MathodLambda::put;
        Supplier<String> s = () -> MathodLambda.put();

        System.out.println(s.get());
        /**
         *
         * 功能描述: 静态方法引用    有参无输出
         *
         */
        Consumer<Integer> c = MathodLambda::set;
        Consumer<Integer> c1 = (size) -> MathodLambda.set(size);
        c.accept(10);


        /**
         *
         * 功能描述: 静态方法引用   有参有输出
         *
         */

        Function<String,String> f1 = str -> str.toUpperCase();
        Function<String,String> f2 = str->MathodLambda.toUpperCase(str);
        Function<String,String> f3 = MathodLambda::toUpperCase;
        System.out.println( f3.apply("lamea"));


        BiFunction<String ,String,Integer> bf1 = (ss1,ss2)-> ss1.length()+ss2.length();
        BiFunction<String ,String,Integer> bf2 = (ss1,ss2)-> MathodLambda.len(ss1,ss2);
        BiFunction<String ,String,Integer> bf3 = MathodLambda::len;
        System.out.println(bf3.apply("abd","eff"));



    }
}
