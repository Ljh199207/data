package com.data.basejava.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormate {



    public static void main(String[] args) {
        Date date  = new Date();
        long time = date.getTime();
        System.out.println(time);

        Date date2  = new Date(1532934329819L*2);
        System.out.println(date2);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d =  simpleDateFormat.format(date);
        System.out.println(d);

    }


}
