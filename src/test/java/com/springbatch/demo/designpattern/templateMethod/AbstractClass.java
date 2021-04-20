package com.springbatch.demo.designpattern.templateMethod;

/**
 * 可见模板方法模式，定义好了算法流程，先执行SpecificMethod方法， abstractMethod1，再执行abstractMethod2
 * 这样的行为设计，可以保障父类做一个部分实现，然后定义好抽象方法让子类去实现，这样保证父类执行的时候，能够执行子类的自定义实现
 * 类比spring源码中 onRefresh()方法
 */
//抽象类
abstract class AbstractClass {
    //模板方法 定义好了算法流程 依次执行方法SpecificMethod，abstractMethod1，abstractMethod2，但具体的算法细节由各个特定子类来实现
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();

    }
    //具体方法
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }
    //抽象方法1
    public abstract void abstractMethod1();
    //抽象方法2
    public abstract void abstractMethod2();
}
