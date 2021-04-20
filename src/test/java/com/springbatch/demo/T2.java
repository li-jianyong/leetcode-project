package com.springbatch.demo;

import org.junit.Test;

public class T2 {

    @Test
    public void test(){
        Person p1 = new Person(1);
        changePerson(p1);
        System.out.println(p1.age);
    }
    void changePerson(Person p) {
        p.age = 2;
    }
}
class Person{
    public int age;
    public Person(int age) {
        this.age = age;
    }
}
