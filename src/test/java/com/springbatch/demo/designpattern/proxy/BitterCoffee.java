package com.springbatch.demo.designpattern.proxy;

public class BitterCoffee implements Coffee {
    @Override
    public void printMaterial() {
        System.out.println("咖啡");
    }
}
