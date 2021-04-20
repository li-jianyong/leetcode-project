package com.springbatch.demo.designpattern.observer;

/**
 * 观察者，被观察者
 * 被观察者实现被观察者接口（添加观察者，移除观察者，通知观察者），具体被观察者即主题内部维护一个列表，用来维护观察者，信息变更是调用通知观察者方法，遍历每一个观察者调用观察者的更新方法
 * 观察者，实现观察者接口（更新方法），
 *
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 创建一个具体被观察者
        WeChatServer server = new WeChatServer();
        // 创建第一个观察者
        Observer userZhang = new User("ZhangSan");
        // 创建第二个观察者
        Observer userLi = new User("LiSi");
        // 创建第三个观察者
        Observer userWang = new User("WangWu");
        // 分别注册到被观察者维护的列表里
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        // 被观察者产生行为发生变化
        server.setInfomation("PHP是世界上最好用的语言！");
        System.out.println("----------------------------------------------");
        //李四取消订阅
        server.removeObserver(userLi);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }
}
