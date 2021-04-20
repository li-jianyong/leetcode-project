package com.springbatch.demo.model;

// 饱汉式变种1.0 直接添加同步关键字保证原子性
public class Singleton2 {
    private static Singleton2 singleton = null;
    private Singleton2(){

    }
    public static synchronized Singleton2 getInstance(){
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
