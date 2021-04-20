package com.springbatch.demo.designpattern.decorator;


public class BitterCoffee implements Coffee {
    @Override
    public void printMaterial() {
        System.out.println("咖啡");
    }
}
