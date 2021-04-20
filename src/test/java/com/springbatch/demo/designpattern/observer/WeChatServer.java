package com.springbatch.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者，实现抽象被观察者接口，覆盖所有抽象方法
 */
public class WeChatServer implements Observable{
    private List<Observer> list;
    private String message;
    public WeChatServer(){
        list = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }
    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++){
            Observer observer = list.get(i);
            observer.update(message);
        }
    }
    public void setInfomation(String s){
        this.message = s;
        System.out.println("公众号推送消息是"+s);
        notifyObserver();
    }
}
