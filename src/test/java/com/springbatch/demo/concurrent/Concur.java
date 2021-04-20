package com.springbatch.demo.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @ClassName:Concur
 * @author: Administrator
 * @Date: 2020/11/24 17 24
 **/
public class Concur {
    @Test
    public void t() throws Exception {
        System.out.println(Thread.currentThread().getName()+"执行");
        Callable task = new CallDemo();
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<String> future = es.submit(task);
        // 防止无限等待，设置超时时间
        String result = "";
        try{
            result = future.get(1,TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("异步任务调用超时");
        }
        System.out.println(result);
        System.out.println("返回结果");
        // Future接口，具备判断当前线程运行状态，isDone，cancel,isCancelled,get,get超时等方法，不具备通知功能，需要CPU一直轮询结果，或者阻塞等待返回
        // CompletableFuture
    }
    @Test
    public void t2(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->"hello");
        future.complete("world");

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t1(){
        System.out.println(Thread.currentThread().getName()+"执行");
        Thread td = new ThreadDemo();
        td.start();
        System.out.println("线程执行完");
        try {
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/** 覆盖call方法体
 * 带返回值
 */
class CallDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"执行");
        System.out.println("线程体执行");
        TimeUnit.SECONDS.sleep(3);
        return "aaa";
    }
}

/** 覆盖run方法
 * 实现runnable无返回值
 */
class RunnableDemo  implements Runnable{

    @Override
    public void run() {
        System.out.println("runable执行体");
        System.out.println(Thread.currentThread().getName()+"执行");
    }
}
class ThreadDemo extends Thread {
    @Override
    public void run(){
        List<A> aList = new ArrayList<>();
        aList.add(new A(1,"aaa"));
        aList.add(new A(2,"bbb"));
        aList.add(new A(3,"ccc"));
        // aList转成map
        Map<Integer,A> map =  aList.stream().collect(Collectors.toMap(A::getId, p->p));
        // 求总数
        Long count = aList.stream().collect(Collectors.counting());
        // 求最大数
        Double averate = aList.stream().collect(Collectors.averagingDouble(A::getId));

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t " + entry.getValue());
        }

        System.out.println(Thread.currentThread().getName()+"执行中。。。");
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"执行中。。。");
    }
}
@Data
@AllArgsConstructor
class A{
    private int id;
    private String name;
}