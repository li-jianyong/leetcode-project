package com.springbatch.demo.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CoffeeCglibProxy implements MethodInterceptor {
    private Object target;
    public Object getProxy(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 将传入的类作为父类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        if ("printMaterial".equals(method.getName())) {
            System.out.println("方法被过滤掉了");
        }
        System.out.println("执行cglib代理增强的逻辑");
        obj = method.invoke(target,objects);
        return obj;
    }
}
