package com.springbatch.demo.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SwapPrint {

    public static void main(String[] args) {
        PrintTask printTask = new PrintTask(36);
        new Thread(new Runnable() {
            @Override
            public void run() {
                    printTask.printA();
            }
        }, "线程A:").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    printTask.printB();
            }
        }, "线程B:").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    printTask.printC();
            }
        }, "线程C:").start();
    }

}
class PrintTask {
    int flag;
    int count = 1;
    int max;
    public PrintTask(int max) {
        this.max = max;
    }
    ReentrantLock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    public void printA(){
        while (count<=max) {
            lock.lock();
            try{
                while (flag % 3 != 0) {
                    conditionA.await();
                }
                for (int i=0;i<3 && count <= max;i++) {
                        System.out.println(Thread.currentThread().getName() + count++);
                }
                flag++;
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    public void printB(){
        while (count <= max) {
            lock.lock();
            try{
                while (flag % 3 != 1) {
                    conditionB.await();
                }
                for (int i=0;i<3 && count<=max;i++) {
                        System.out.println(Thread.currentThread().getName() + count++);
                }
                flag++;
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    public void printC(){
        while (count <= max) {
            lock.lock();
            try{
                while (flag % 3 != 2) {
                    conditionC.await();
                }
                for (int i=0;i<3&&count <= max;i++) {
                        System.out.println(Thread.currentThread().getName() + count++);
                }
                flag++;
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}