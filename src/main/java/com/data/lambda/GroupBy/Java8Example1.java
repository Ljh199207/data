package com.data.lambda.GroupBy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * @Auther: ljh
 * @Date: 2018/11/21 10:03
 * @Description:   Group by a List and display the total count of it.
 */
public class Java8Example1 {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting())
        );
        System.out.println(result);

        //Add sorting.
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);






    }
}
