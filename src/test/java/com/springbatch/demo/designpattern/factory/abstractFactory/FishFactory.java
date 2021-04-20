package com.springbatch.demo.designpattern.factory.abstractFactory;

import com.springbatch.demo.designpattern.factory.simpleFactory.Fish;
import com.springbatch.demo.designpattern.factory.simpleFactory.Resaurant;

/**
 * 具体工厂，继承抽象工厂类，并实现抽象工厂类的抽象方法
 */
public class FishFactory extends CookFactory {
    public Resaurant createRestaurant() {
        return new Fish();
    }
}