package com.springbatch.demo.model;

public class Singleton3 {
    private static Singleton3 singleton = null;
    public int f1 = 1;
    public int f2 = 2;
    private Singleton3(){
    }
    public static Singleton3 getInstance(){
        if (singleton ==null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
