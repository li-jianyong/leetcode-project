package com.springbatch.demo.designpattern.observer;


/**
 * 主题，被观察者，提供注册观察者，移除观察者，通知观察者等功能
 */
public interface Observable {
    //注册观察者
    void registerObserver(Observer observer);
    //取消观察者
    void removeObserver(Observer observer);
    //通知所有观察者更新消息
    void notifyObserver();
}
