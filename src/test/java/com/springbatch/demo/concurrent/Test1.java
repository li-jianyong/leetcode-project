package com.springbatch.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    volatile int count = 1;
    ReentrantLock lock = new ReentrantLock();
    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("线程A执行开始");
            for (int i=0;i<100000;i++) {
                count++;
            }
            System.out.println("线程A执行结束");
            lock.unlock();
        });
        t1.setName("线程A");
        t1.start();
        Thread t2 = new Thread(() -> {
            lock.lock();
            System.out.println("线程B执行开始");
            for (int i=0;i<100000;i++) {
                count++;
            }
            System.out.println("线程B执行结束");
            lock.unlock();
        });
        t2.setName("线程B");
        t2.start();
        Thread t3 = new Thread(() -> {
            lock.lock();
            System.out.println("线程C执行开始");
            for (int i=0;i<100000;i++) {
                count++;
            }
            System.out.println("线程C执行结束");
            lock.unlock();
        });
        t3.setName("线程C");
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(count);
    }
}
