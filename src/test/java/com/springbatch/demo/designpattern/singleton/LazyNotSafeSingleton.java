package com.springbatch.demo.designpattern.singleton;

public class LazyNotSafeSingleton {
    private static LazyNotSafeSingleton instance;
    private LazyNotSafeSingleton() {}

    /** 懒汉式，非线程安全，非原子组合操作
     * @return
     */
    public static LazyNotSafeSingleton getInstance() {
        if (instance == null) instance = new LazyNotSafeSingleton();
        return instance;
    }
}
