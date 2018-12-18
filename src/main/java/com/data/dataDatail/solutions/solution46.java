package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ljh
 * @Date: 2018/12/4 09:10
 * @Description: 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
 * 利用字典，一趟遍历，key为值，value为出现的次数，
 * 如果出现的次数大于length/2，则返回key，否则未找到
 */
public class solution46 {

    public static void main(String[] args) {
        List<Integer> m = new ArrayList<>();
        m.add(1);
        m.add(1);
        m.add(1);
        m.add(1);
        m.add(1);
        m.add(2);
        m.add(2);
        m.add(3);

        majorityNumber(m);
    }

    public static  int majorityNumber(List<Integer> nums) {
        // write your code here
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer:nums) {
           if(!map.containsKey(integer)){
               map.put(integer,1);
           }
           else {
               Integer value = map.get(integer);
               map.put(integer,value+1);
           }
        }
        int n =0;int m=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>m){
                m=entry.getValue();
                n=entry.getKey();
            }
        }
        System.out.println(m+"--"+n);

        return  n;
    }
}
