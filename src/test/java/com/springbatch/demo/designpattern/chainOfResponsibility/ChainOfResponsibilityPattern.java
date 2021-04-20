package com.springbatch.demo.designpattern.chainOfResponsibility;

/**
 * 每一层节点组装成链，对请求进行处理，根据自定义逻辑判断是否进行处理或者转发，每层节点维护好下一层节点的引用
 * 适合场景：多个对象处理一个请求，具体由哪个对象运行时自动确定；分为两类，纯粹职责链全部某一个对象处理，不纯粹的几个对象分别处理部分
 */
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
