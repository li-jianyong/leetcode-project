package com.springbatch.demo.test1;

import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

public class TestType {
    @Test
    public void test01() throws ClassNotFoundException {
        Integer[] a = {1};
        System.out.println(a.getClass().getTypeName());
//        B b = new B();
//        Class<A> clazz = (Class<A>) Class.forName("com.springbatch.demo.test1.TestType$A");
        Class cla = A.class;
        System.out.println(cla.isAssignableFrom(B.class));
    }

    class A {
    }
    class B extends A {

        public B(){
            System.out.println("初始化B");
        }
    }

    @Test
    public void t1(){
        int emp = 10 - '3' + '0';
        System.out.println(emp);
    }
}
