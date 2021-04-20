package com.springbatch.demo.designpattern.factory.simpleFactory;

/**
 * 简单工厂模式
 */
public class SimpleFactory {
    public static void main(String[] args) {
        //简单工厂模式
        Resaurant resaurant = Wait.getMean(Wait.MEAN_DUCK);
        resaurant.cook();
    }
}
