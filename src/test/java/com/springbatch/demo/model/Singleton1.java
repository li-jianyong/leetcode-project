package com.springbatch.demo.model;
// 饱汉式
public class Singleton1 {
    private static Singleton1 singleton = null;
    // 私有构造
    private Singleton1(){
    }

    public static Singleton1 getInstance() {
        // if 判断和赋值操作，多线程环境下存在竞态条件
        if (singleton == null){
            singleton = new Singleton1();
        }
        return  singleton;
    }
}
