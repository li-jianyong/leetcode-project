package com.springbatch.demo.service;


public abstract class AbstractAction {
    public String name;

    public abstract void doAction();
    public void test(){
        System.out.println(name);
    }
}
