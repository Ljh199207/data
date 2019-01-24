package com.data.mode.observer.observerJDK;

import com.data.mode.observer.Observer;
import com.data.mode.observer.Subject;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @Auther: ljh
 * @Date: 2019/1/16 11:09
 * @Description:
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }
    public void measurementsChangs(){
        setChanged();
        notifyObservers();
    }



    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChangs();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
