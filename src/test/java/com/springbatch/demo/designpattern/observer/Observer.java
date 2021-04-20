package com.springbatch.demo.designpattern.observer;

/**
 * 抽象观察者接口，提供一个更新的方法
 */
public interface Observer {
    void update(String message);
}
