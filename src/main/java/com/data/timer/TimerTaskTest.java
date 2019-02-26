package com.data.timer;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Auther: ljh
 * @Date: 2018/9/20 16:01
 * @Description:
 */
public class TimerTaskTest {

    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new task(),1000,3000);
    }
}

class  task extends TimerTask {
    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
