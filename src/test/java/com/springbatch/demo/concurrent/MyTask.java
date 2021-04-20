package com.springbatch.demo.concurrent;

public class MyTask {

    public synchronized void printNumber(int i) {
        try {
            this.notify();
            System.out.println(Thread.currentThread().getName() + " " + i);
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
