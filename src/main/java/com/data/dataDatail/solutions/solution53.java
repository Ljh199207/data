package com.data.dataDatail.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/12/4 15:27
 * @Description:
 */
public class solution53 {

    public static void main(String[] args) {
        String s = "the sky  is blue";
        String words[] = s.split(" ");
        List<String> list = new ArrayList<>();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            if(!("").equals(words[i]))
            {
                stringBuffer.append(" ");
                list.add(words[i]);
            }
            stringBuffer.append(words[i]);
        }

        /*for (String string : list) {
            System.out.print(string);
        }*/


        System.out.println(reverseWords("the sky  is blue"));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }


}
