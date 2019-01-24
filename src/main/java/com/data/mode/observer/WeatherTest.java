package com.data.mode.observer;


/**
 * @Auther: ljh
 * @Date: 2019/1/16 11:48
 * @Description:
 */
public class WeatherTest {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.registerObserver(currentConditionDisplay);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.4f);
        weatherData.setMeasurements(78,90,29.2f);

    }

}
