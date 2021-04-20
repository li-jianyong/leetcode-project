package com.springbatch.demo.designpattern.strategy;

/**
 * 策略模式，传入不同的策略对象，调用不同策略对象的方法完成不同的策略；
 */
public class Context {
    Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy  = strategy;
    }
    public void contextInterface(){
        strategy.algorithmInterface();
    }
}
/*
* 策略模式 元素：context,抽象strategy,algorithmInterface方法，目的传入对象strategy,并实现策略方法，各个子类实现算法逻辑
* 模板方法 元素 抽象父类，模板方法定义了一系列抽象方法，也就是父类定义好了模板方法的调用各个方法，子类继承父类实例化各个抽象方法，客户端调用传入具体的子类，选择子类的该
*       方法来完成模板方法的各个细节部分；
* 委派模式 元素 委派类，实现类，接口，三者都实现接口，但是委派类在实现方法时，是通过其他实现类来完成这部分逻辑处理
* 不同于策略，策略类只是持有策略接口，客户端访问类调用方法时，直接调用策略接口实现类的方法调用，可以根据传入不同的策略，来修改策略无需修改客户端访问类，实现开闭
* 这两种方法依据粒度适用于不同的场景，比如说，再完成一系列外部接口调用的场景，定义好调用步骤的逻辑，可以尝试使用模板方法的模式，定义好统一的接口
* */