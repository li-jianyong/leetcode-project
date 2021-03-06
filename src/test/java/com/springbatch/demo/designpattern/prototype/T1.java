package com.springbatch.demo.designpattern.prototype;

import org.junit.Test;

public class T1 {
    @Test
    public void test(){
        Resume a = new Resume("James");
        a.setPersonInfo("2.16", "男", "家里蹲大学");
        a.setWorkExperience("2018.09.05", "搬砖工地");
        //克隆B对象
        Resume b = (Resume) a.clone();
        //输出A和B对象
        System.out.println("----------------A--------------");
        a.display();
        System.out.println("----------------B--------------");
        b.display();
        /*
         * 测试A==B?
         * 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象
         */
        System.out.print("A==B?");
        System.out.println( a == b);
        /*
         * 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
         */
        System.out.print("A.getClass()==B.getClass()?");
        System.out.println(a.getClass() == b.getClass());
    }
}
