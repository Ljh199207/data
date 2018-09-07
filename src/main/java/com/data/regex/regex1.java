package com.data.regex;

import java.util.regex.Pattern;

/**
 * @Auther: ljh
 * @Date: 2018/9/6 09:19
 * @Description:
 */
public class regex1 {

    public static void main(String[] args) {
        String str = "123124";
        //   System.out.println(isNumber(str));
        //正则表达式
        System.out.println(str.matches("\\d+"));


        String str1 = "只能是中文";
        String reg1 = "[\u4E00-\u9FFF]+";
        System.out.println(str1.matches(reg1));

        String str2 = "雙字節包括中文";
        String reg2 = "[^\\x00-\\xff]+";
        System.out.println(str2.matches(reg2));

        String str3 = "15100000000";
        String reg3 = "(13[0-9]|14[5|7]|15[0-3|5-9]|17[0-9]|18[0-9])\\d{8}";
        System.out.println(str3.matches(reg3));


        String str4 = "56";
        String reg4 = "(\\-|\\+)?[1-9]\\d*";
        System.out.println(str4.matches(reg4));

        String str5 = "1.15";
        String reg5 = "(\\-|\\+)?\\d+\\.\\d+";
        System.out.println(str5.matches(reg5));
    }

    public static boolean isNumber(String data) {
        char[] result = data.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] < '0' || result[i] > '9') {
                return false;
            }
        }
        return true;
    }


}
