package com.springbatch.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义实现阻塞队列 基于Condition
 */
public class AxinBlockQueue {
    private List<Integer> container = new ArrayList<>();
    // 当前队列大小
    private volatile int size;
    // 当前队列的最大容量
    private volatile int capacity;
    private Lock lock = new ReentrantLock();
    // condition
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();
    // 实例化，传入容量大小
    AxinBlockQueue(int cap) {
        this.capacity = cap;
    }
    public void add(int data) {
        try {
            lock.lock();
            try {
                // 超过容量了
                while (size >= capacity) {
                    System.out.println("阻塞队列满了");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                // 响应中断
                isFull.signal();
                System.out.println("阻塞中断");
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }
    // 取出元素
    public int take() {
        try {
            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("队列空，阻塞");
                    // condition等待，不会不断自旋；等待被唤醒
                    isNull.await();
                }
            } catch (InterruptedException e) {
                // 如果当前状态被中断，那么将唤醒isNull的线程
                isNull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AxinBlockQueue queue = new AxinBlockQueue(5);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
                System.out.println("塞入" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t2 = new Thread( () -> {
            for(;;) {
                System.out.println("消费" + queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
