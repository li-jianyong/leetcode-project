package com.springbatch.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName:SemaporeDemo
 * @author: Administrator
 * @Date: 2020/9/27 14 42
 **/
public class SemaporeDemo {
    ExecutorService service = Executors.newCachedThreadPool();
    // LinkedBlockingQueue 1 1
    ExecutorService service1 = Executors.newSingleThreadExecutor();
    // LinkedBlockingQueue
    ExecutorService service2 = Executors.newFixedThreadPool(10);
    // ScheduledThreadPoolExecutor.DelayedWorkQueue延时队列
    ExecutorService service3 = Executors.newScheduledThreadPool(10);


    Semaphore sh = new Semaphore(3);

    @Test
    public void t1() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sh.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (3-sh.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                    sh.release();
                    System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (3-sh.availablePermits()) + "个并发");
                }
            };
            service.submit(runnable);
        }
    }

}
