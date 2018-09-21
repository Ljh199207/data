package com.data.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther: ljh
 * @Date: 2018/9/12 14:25
 * @Description:
 */
public class StreamDemo1 {
    //创建Stream 对象 数组
    public static void gen1() {
        String a[] = {"a", "b", "c", "d"};
        Stream<String> stream = Stream.of(a);
    }

    //创建Stream 集合
    public static void gen2() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
    }

    //创建Stream  Stream.generate
    public static void gen3() {
        Stream<Integer> stream = Stream.generate(() -> 1);
    }

    //创建Stream  Stream.iterate
    public static void gen4() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
    }

    //创建Stream  其他
    public static void gen5() throws IOException {
        String str = "234546";
        IntStream stream = str.chars();

        //   stream.forEach(x-> System.out.println(x));
        stream.forEach(System.out::println);

        Files.lines(Paths.get("D:/nginx.conf")).forEach(System.out::println);

    }


    public static void main(String[] args) throws IOException {
        // StreamDemo1.gen5();


        //中间操作和终止操作
/*
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        int sum = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);


        int max = Arrays.asList(1, 2, 3, 4, 5).stream().max((a, b) -> a - b).get();
        System.out.println(max);


        int min = Arrays.asList(1, 2, 3, 4, 5).stream().min((a, b) -> a - b).get();
        System.out.println(min);
*/



        // 并行操作 .parallel()     串行sequential()

        Optional<Integer> optional = Stream.iterate(1,x->x+1).limit(200).peek(x->{
            System.out.println(Thread.currentThread().getName());
        }).parallel().sequential().max(Integer::compareTo);

        System.out.println(optional);


    }
}
