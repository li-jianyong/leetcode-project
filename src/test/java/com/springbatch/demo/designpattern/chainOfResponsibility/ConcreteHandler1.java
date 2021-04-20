package com.springbatch.demo.designpattern.chainOfResponsibility;

/**
 * 继承抽象基类，实现处理请求的方法，
 */
public class ConcreteHandler1 extends Handler{
    public void handleRequest(String request) {
        // 节点判断是否处理或者进行转发，
        // 根据请求参数的类型，交由对应的处理器去处理，职责分离清楚，如果是one，自行处理，其他则再判断交由其他处理器进行处理
        if (request.equals("one")) {
            System.out.println("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                // 进行转发
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
