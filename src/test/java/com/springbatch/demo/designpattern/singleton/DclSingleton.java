package com.springbatch.demo.designpattern.singleton;

/**
 * DCL单例
 */
public class DclSingleton {
    private static volatile DclSingleton instance;
    private DclSingleton(){}
    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
                return instance;
            }
        }
        return instance;
    }
}
