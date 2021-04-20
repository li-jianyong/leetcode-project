package com.springbatch.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    private Object lockA = new Object();
    private Object lockB = new Object();
    public void handleOne() {
        synchronized (lockA) {
            try {
                System.out.println("拿到A锁，短暂休眠尝试拿B锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                    System.out.println("handleOne执行任务");
                }
            }
        }
    public void handleTwo() {
        synchronized (lockB) {
            try {
                System.out.println("拿到B锁，短暂休眠尝试拿A锁");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockA) {
                    System.out.println("handleTwo执行任务");
                }
            }
        }
    @Test
    public void test(){
        DeadLockDemo deadLockDemo = new DeadLockDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 第一个任务执行one方法
        Task taskA = new Task(1);
        // 第一个任务执行two方法
        Task taskB = new Task(0);
        executorService.submit(taskA);
        executorService.submit(taskB);
        for(;;)
        System.out.println();
    }

    class Task implements Runnable {
        private int chioce;
        public Task(int chioce) {
            this.chioce = chioce;
        }
        @Override
        public void run() {
            if (chioce == 1) {
                handleOne();
            } else {
                handleTwo();
            }
        }
    }
}
