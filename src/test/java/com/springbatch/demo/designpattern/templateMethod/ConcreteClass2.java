package com.springbatch.demo.designpattern.templateMethod;

public class ConcreteClass2  extends AbstractClass{
    @Override
    public void abstractMethod1() {
        System.out.println("子类实现的抽象方法1");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("子类实现的抽象方法2");
    }
}
