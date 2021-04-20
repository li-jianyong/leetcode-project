package com.springbatch.demo.designpattern.proxy;

import org.junit.Test;

public class T1 {
    /**
     * 基于JDK的动态代理，需要类实现接口，返回该接口的代理对象，调用代理对象复写的方法；
     */
    @Test
    public void testJdkProxy(){
        CoffeeDynamicProxy coffeeDynamicProxy = new CoffeeDynamicProxy();
        BitterCoffee bitterCoffee = new BitterCoffee();
        Coffee proxy = (Coffee)coffeeDynamicProxy.getProxy(bitterCoffee);
        proxy.printMaterial();

    }

    /**
     * 基于Cglib代理生成子类覆盖父类的方法，进行方法增强，那么被代理类不能为final方法，因为必须能够覆盖此方法才行
     */
    @Test
    public void testCglib(){
        CoffeeCglibProxy coffeeCglibProxy = new CoffeeCglibProxy();
        Coffee proxy = (Coffee) coffeeCglibProxy.getProxy(new BitterCoffee());
        proxy.printMaterial();
    }
}
