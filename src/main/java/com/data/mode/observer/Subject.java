package com.data.mode.observer;

/**
 * @Auther: ljh
 * @Date: 2019/1/16 11:01
 * @Description:
 */
public interface Subject {
    public  void registerObserver(Observer o);
    public  void removerObserver(Observer o);
    public  void notifyObservers();
}
