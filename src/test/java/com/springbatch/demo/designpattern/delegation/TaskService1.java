package com.springbatch.demo.designpattern.delegation;

public class TaskService1 implements Task{
    @Override
    public void doTask() {
        System.out.println("实例对象1执行任务");
    }
}
