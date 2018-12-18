package com.data;

import com.data.mode.template.Coffee;
import com.data.mode.template.RefreshBevera;
import com.data.mode.template.Tea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerDataApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public  void testCoffee(){
        System.out.println("制备咖啡。。。");
        RefreshBevera b1 = new Coffee();
        b1.preparBeverageTemplage();
        System.out.println("咖啡好了！");

        System.out.println("\n************************************");

        System.out.println("制备茶叶。。。");
        RefreshBevera t1 = new Tea();
        t1.preparBeverageTemplage();
        System.out.println("茶好了");
    }





}
