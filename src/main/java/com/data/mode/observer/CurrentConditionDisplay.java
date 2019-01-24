package com.data.mode.observer;

/**
 * @Auther: ljh
 * @Date: 2019/1/16 11:36
 * @Description:
 */
public class CurrentConditionDisplay implements  Observer ,DisplayElement  {

    private  Subject weatherData;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
    }

    @Override
    public void display() {
        System.out.println("Current conditions "+temperature +"F degree and "+humidity+"% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
       this.temperature = temp;
       this.humidity =humidity;
        display();
    }
}
