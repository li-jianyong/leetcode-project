package com.springbatch.demo.designpattern.singleton;

public class T {
    private static final T instance = new T();
    private T(){}
    public static T getInstance() {
            return instance;

    }
}
