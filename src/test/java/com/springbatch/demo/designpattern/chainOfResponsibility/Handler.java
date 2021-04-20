package com.springbatch.demo.designpattern.chainOfResponsibility;

/**
 * 抽象基类，维持下一个处理器的next引用
 */
public abstract class Handler {
    private Handler next;
    public void setNext(Handler next) {
        this.next = next;
    }
    public Handler getNext() {
        return next;
    }
    // 处理请求的方法
    public abstract void handleRequest(String request);
}
