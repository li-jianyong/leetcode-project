package com.springbatch.demo.designpattern.templateMethod;

import org.junit.Test;

public class T1 {
    @Test
    public void test(){
        AbstractClass tm = new ConcreteClass();
        // 客户端使用的时候，直接调用模板方法，具体的方法细节由实例化的子类去实现；这里就是使用的ConcreteClass实例，实现的方法细节
        tm.templateMethod();
    }
    @Test
    public void test1(){
        AbstractClass cm2 = new ConcreteClass2();
        cm2.templateMethod();
    }
}
