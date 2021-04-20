package com.springbatch.demo.designpattern.strategy;

/**
 * 每个策略实现类都实现策略接口，实现算法
 */
public class ConcreteStrategyC implements Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("算法C实现");
    }
}
