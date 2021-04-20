package com.springbatch.demo.designpattern.proxy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class CoffeeStaticProxy implements Coffee {
    private final Coffee coffee;

    /** 静态代理 不同于装饰器模式的区别在于 此处通过new 一个对象，而不是直接使用别人传入进来的对象。
     *  装饰器模式 实例来源于被装饰对象本身new出来的，只是传到装饰器类对象里，来在此基础上进行增强；
     *  而静态代理 则是代理类来new自己想要的对象
     *  io流则使用装饰器模式，层层增加功能，将自己创建的对象，交给别的类进行装饰增强，
     *  代理对象更像是 用来控制对象的访问级别 创建代理可以先判断逻辑再决定是否可以允许访问被代理对象；
     *  装饰器对象 更简单的增加被装饰器对象的功能，功能增强修饰
     */
    public CoffeeStaticProxy() {
        this.coffee = new BitterCoffee();
    }
    @Override
    public void printMaterial() {
        System.out.println("静态代理的逻辑");
        this.coffee.printMaterial();
    }
    public String minNumber(int[] nums) {
        if(nums==null || nums.length == 0) return "";
        int len = nums.length;
        String[] res = new String[len];
        for(int i=0;i<len;i++) {
            res[i] = String.valueOf(nums[i]);
        }
        StringBuilder ans = new StringBuilder();
        Arrays.sort(res, new Comparator<String>(){
            public int compare(String s1,String s2) {
                String c1 = s1+s2;
                String c2 = s2+s1;
                return c1.compareTo(c2);
            }
        });
        for(String tmp : res) {
            ans.append(tmp);
        }
        return ans.toString();
    }
}
