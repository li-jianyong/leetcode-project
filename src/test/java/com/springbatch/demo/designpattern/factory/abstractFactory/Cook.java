package com.springbatch.demo.designpattern.factory.abstractFactory;

import com.springbatch.demo.designpattern.factory.simpleFactory.Resaurant;

public class Cook {
    //工厂方法模式
    public static void main(String[] args) {
        Resaurant duck = new DuckFactory().createRestaurant();
        duck.cook();
        Resaurant fish = new FishFactory().createRestaurant();
        fish.cook();
    }
}