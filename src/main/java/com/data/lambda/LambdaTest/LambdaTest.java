package com.data.lambda.LambdaTest;


import org.junit.Test;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: ljh
 * @Date: 2018/9/14 11:42
 * @Description:
 */
public class LambdaTest {

    /**
     * 功能描述:
     * index.do?itemId=1&userId=123123&type=12&taken=12312312412&key=index
     */
    @Test
    public void test() {

        String queryString = "itemId=1&userId=123123&type=12&taken=12312312412&key=index";
        Map<String, String> map = Stream.of(queryString.split("&")).map(str -> str.split("=")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
        System.out.println(map.toString());
    }

    @Test
    public  void test2(){
       // books().stream().map(book -> book.getId()).forEach(System.out::println);

        List<Integer> ids = books().stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(ids);

        String str = books().stream().map(book -> book.getId()+"").collect(Collectors.joining(","));
        System.out.println(str);

        String str2 = books().stream().map(book -> book.getId()+"").collect(Collectors.joining(",","(",")"));
        System.out.println(str2);

        String str3 = books().stream().map(book -> "'"+ book.getId()+"'").collect(Collectors.joining(",","(",")"));
        System.out.println(str3);

    }

    @Test
    public  void tes3(){

        List<String> type = books().stream().map(book -> book.getType()).collect(Collectors.toList());
        System.out.println(type);

        //去重
        List<String> type2 = books().stream().map(book -> book.getType()).distinct().collect(Collectors.toList());
        System.out.println(type2);

        //去重
        Set<String> type3 = books().stream().map(book -> book.getType()).collect(Collectors.toSet());
        System.out.println(type3);


    }


    @Test
    public  void tes4(){

        //排序
      //  books().stream().sorted((book1,book2)->Double.compare(book1.getPrice(),book2.getPrice())).forEach(System.out::println);

    /*    Comparator<Book> com = (book1, book2)->Double.compare(book1.getPrice(),book2.getPrice());
        books().stream().sorted(com.reversed()).forEach(System.out::println);*/

  /*      Comparator<Book> com = (book1, book2)->Double.compare(book1.getPrice(),book2.getPrice());
        Comparator<Book> com1 = (book1, book2)->book1.getPublishDate().isAfter(book2.getPublishDate())?1:-1;
        books().stream().sorted(com.thenComparing(com1)).forEach(System.out::println);*/

        //再简化
        books().stream().sorted(Comparator.comparing(Book::getPrice).reversed().thenComparing(Comparator.comparing(Book::getPublishDate))).forEach(System.out::println);
    }

    @Test
    public  void tes5(){
    Map<Integer,Book> map =  books().stream().collect(Collectors.toMap(book->book.getId(),book->book));
        System.out.println(map);
    }


    @Test
    public  void tes6(){
 /*    Double price = books().stream().collect(Collectors.averagingDouble(Book::getPrice));
     System.out.println(price);

       Optional<Book> book  = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
        System.out.println(book);


        Optional<Book> book1  = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice)));
        System.out.println(book1);*/

        Optional<Book> book  = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice)));
        Comparator<Book> book1  = Comparator.comparing(Book::getPrice);
        book = books().stream().collect(Collectors.maxBy(book1.thenComparing(Comparator.comparing(Book::getPublishDate))));
        System.out.println(book);

    }

    @Test
    public  void tes7(){
       Map<String,List<Book>> map = books().stream().collect(Collectors.groupingBy(Book::getType));
       map.keySet().forEach(key->{
           System.out.println(key);
           System.out.println(map.get(key));
               }
       );


        Map<String,Long> map1 = books().stream().collect(Collectors.groupingBy(Book::getType,Collectors.counting()));
        System.out.println(map1);
    }


    public List<Book> books (){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"java",56d,"A",LocalDate.parse("2014-02-01")));
        books.add(new Book(2,"tomcate",51d,"B",LocalDate.parse("2013-02-04")));
        books.add(new Book(3,"nginx",52d,"C",LocalDate.parse("2014-02-07")));
        books.add(new Book(4,"php",53d,"D",LocalDate.parse("2017-05-01")));
        books.add(new Book(5,".net",54d,"A",LocalDate.parse("2015-02-01")));
        books.add(new Book(6,"算法",55d,"A",LocalDate.parse("2013-02-01")));
        books.add(new Book(7,"javascript",56d,"B",LocalDate.parse("2011-02-01")));
        books.add(new Book(8,"jqery",51d,"B",LocalDate.parse("2014-03-01")));
        books.add(new Book(9,"python",52d,"C",LocalDate.parse("2014-04-01")));
        return books ;
    }



    public static void main(String[] args) {

        String a = "/0/1/2/3/4";
        String b = a.substring(a.indexOf("/", 3) + 1);
        System.out.println(b);
    }

}



