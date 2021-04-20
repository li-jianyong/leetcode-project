package com.springbatch.demo.designpattern.factory.abstractFactory;

import com.springbatch.demo.designpattern.factory.simpleFactory.Resaurant;

/**
 * 抽象工厂类
 */
public abstract class CookFactory {
    public abstract Resaurant createRestaurant();
}
