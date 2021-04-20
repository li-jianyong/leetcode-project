package com.springbatch.demo.designpattern.singleton;

/**
 * 通过JVM来保证线程安全，写法简洁，目前最佳，正确的写法
 */
public enum EnumSingleton {
    // 枚举类只有一个对象，通过这种方式实现单例
    INSTANCE("1001","success");
    private String code;
    private String msg;
    EnumSingleton(String code,String msg) {
        code = code;
        msg = msg;
    }
    public void doSomething() {
        System.out.println("doSomething");
    }
}
