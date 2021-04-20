package com.springbatch.demo.designpattern.delegation;

import java.util.Random;

/**
 * 可以维护一系列的列表，根据不同的场景，将请求处理委托给不同的列表对象来处理； 不至于每个对象都要对请求进行处理，是否处理取决代码设计逻辑。基于接口实现
 * 类似，职责链，职责链是将所有的对象以类似链表的形式来组织，每个对象都要对请求做决策，是否处理还是进行转发；基于抽象类实现
 */
public class Delegation implements Task{

    @Override
    public void doTask() {
        Task task = null;
        if (new Random().nextBoolean()) {
            task = new TaskService1();
        } else {
            task = new TaskService2();
        }
        task.doTask();
        System.out.println("委派类执行结束");
    }

    public static void main(String[] args) {
        new Delegation().doTask();
    }
}
