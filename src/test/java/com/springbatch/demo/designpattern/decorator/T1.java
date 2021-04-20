package com.springbatch.demo.designpattern.decorator;

import org.junit.Test;

public class T1 {
    @Test
    public void testDecorator() {
        // 装饰器， BitterCoffee实现coffee接口，但是该实例不能满足功能，所以，在这个基础上进行装饰，装饰类持有这个对象，然后增加别的逻辑
        Coffee coffee = new BitterCoffee(); // 点了一杯苦咖啡
        coffee = new CoffeeDecorator(coffee); // 给咖啡加了点糖
        coffee.printMaterial(); // 糖 咖啡
    }

}
