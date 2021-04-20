package com.springbatch.demo.designpattern.singleton;

import org.junit.Test;

public class test {
    @Test
    public void test(){
        // 枚举常量的方式调用方法
        EnumSingleton.INSTANCE.doSomething();
    }
}
