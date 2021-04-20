package com.springbatch.demo.designpattern.decorator;

/**
 * 被装饰对象，已经是个完整的对象，且来源于外部传入，不是自己构造产生；核心在于，装饰者和被装饰者都实现了同一个接口，这样调用的是时候可以屏蔽掉调用细节
 */
public class CoffeeDecorator implements Coffee {
    private final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void printMaterial() {
        System.out.println("糖");
        this.coffee.printMaterial();
    }
}
