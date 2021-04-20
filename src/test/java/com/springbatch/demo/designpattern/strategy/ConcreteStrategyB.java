package com.springbatch.demo.designpattern.strategy;

public class ConcreteStrategyB implements Strategy{

    @Override
    public void algorithmInterface() {
        System.out.println("算法B实现");
    }
}
