package com.springbatch.demo.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName:CyclicBarrierDemo
 * @author: Administrator
 * @Date: 2020/9/27 14 37
 **/
public class CyclicBarrierDemo {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;
        ConcurrentHashMap map = null;
        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                // 一个任务里循环使用，
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                // 第一次使用 执行任务完后进行等待
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                // 第二次重新等待 继续使用栅栏
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 完成最后任务");
            }
        });

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }

}
