package com.springbatch.demo.designpattern.strategy;

import org.junit.Test;

import java.util.Scanner;

/**
 * 对于策略模式，通常可用于优化多重判断的场景，使之更加由扩展性，缺点所有的策略类都需要暴露，
 * 使用场景：多个类只有在算法行为上的差异，如果一个系统策略类多余4个，可以考虑混合模式代替策略类膨胀问题
 * 开发中某个功能存在多个算法策略，可以根据不同的条件选择不同的策略来完成功能，通过将算法封装，将使用算法的责任和实现分离，并委派给不同的对象进行管理
 * 完美支持开闭原则，不修改原有代码情况下，添加新的算法
 * 构成 ： 策略类被一个context持有，然后通过策略类来进行具体调用
 */
public class T1 {
    /**
     * 根据输入的策略，选择不同的策略来实例。这样可以根据不同的入参来决定实例的不同的表现行为
     */
    @Test
    public void test(){
        Context context;
        // 上下文持有Strategy对象，使用时传入不同的策略类进行即可。对于context的调用屏蔽；
        context = new Context(new ConcreteStrategyA());
        // 上下文对象调用contextInterface方法，不需要具体去了解这个方法实现细节，只需要根据实例化时传入不同的策略类
        context.contextInterface();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入打折方式（1/2/3）：");
        int in = scanner.nextInt();
        switch (in) {
            case 1:
                System.out.println("采用A策略");
                context = new Context(new ConcreteStrategyA());
                break;
            case 2:
                System.out.println("采用A策略");
                context = new Context(new ConcreteStrategyB());
                break;
            default:
                System.out.println("采用A策略");
                context = new Context(new ConcreteStrategyC());
                break;
        }
        scanner.close();
    }
}
