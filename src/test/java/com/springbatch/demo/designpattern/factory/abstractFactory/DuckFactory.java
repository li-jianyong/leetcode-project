package com.springbatch.demo.designpattern.factory.abstractFactory;

import com.springbatch.demo.designpattern.factory.simpleFactory.Duck;
import com.springbatch.demo.designpattern.factory.simpleFactory.Resaurant;

/**
 * 具体工厂，继承抽象工厂类，并实现抽象工厂类的抽象方法
 */
public class DuckFactory extends CookFactory {
    @Override
    public Resaurant createRestaurant() {
        return new Duck();
    }
}
