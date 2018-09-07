package com.data.basejava.arrays;

import java.util.Arrays;

/**
 * @Auther: ljh
 * @Date: 2018/9/5 15:16
 * @Description:
 */
public class Comparable {
    public static void main(String[] args) {

      Penson penson[] =new Penson[]{
              new Penson("张三",12),
              new Penson("李四",14),
              new Penson("王五",11),
      };
        Arrays.sort(penson);
        System.out.println(Arrays.toString(penson));
    }

}
