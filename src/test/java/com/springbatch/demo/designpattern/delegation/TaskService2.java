package com.springbatch.demo.designpattern.delegation;

public class TaskService2 implements Task{
    @Override
    public void doTask() {
        System.out.println("实例对象2执行任务");
    }
}
