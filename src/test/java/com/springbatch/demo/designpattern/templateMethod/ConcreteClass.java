package com.springbatch.demo.designpattern.templateMethod;

//具体子类
class ConcreteClass extends AbstractClass {
    // 子类定义具体的方法实现细节
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
