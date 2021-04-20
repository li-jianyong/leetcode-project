package com.springbatch.demo.designpattern.singleton;

/**
 * 静态内部类的方式构造单例，类加载外部类不会直接初始化单例对象，直到调用getInstance才会真正加载内部类SingletonHolder去实例化单例对象
 */
public class InternalClassSingleton {
    private static class SingletonHolder {
        private static final InternalClassSingleton instance = new InternalClassSingleton();
    }
    private InternalClassSingleton(){}
    public static final InternalClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
