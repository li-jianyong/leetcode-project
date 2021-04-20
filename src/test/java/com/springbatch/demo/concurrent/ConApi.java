package com.springbatch.demo.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @ClassName:ConApi
 * @author: Administrator
 * @Date: 2020/9/27 14 04
 **/
public class ConApi {
    ExecutorService executorService = new ThreadPoolExecutor(3, 6, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3), new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("拒绝执行该任务");
        }
    });
    CountDownLatch cd = new CountDownLatch(3);
    @Test
    public void t1() {
        System.out.println("主线程开始执行" + Thread.currentThread().getName() + "开始执行。。。");
        executorService.submit(()->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一次任务执行");
            cd.countDown();
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第二次任务执行");
            cd.countDown();
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第三次任务执行");
            cd.countDown();
        });

        executorService.submit(() -> {
            System.out.println("第四次任务开始执行");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cd.countDown();
        });
        try {
            System.out.println("任务开始等待！");
            cd.await();
            System.out.println("任务等待结束！");
        } catch (InterruptedException e) {
            System.out.println("主线程中断");
            e.printStackTrace();
        }
    }

    @Test
    public void t2() {
        CyclicBarrier cb = new CyclicBarrier(3,()-> {
            System.out.println("栅栏启动");
        });
        executorService.submit(() -> {

            System.out.println("第1个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println("第2个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println("第3个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println("第4个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println("第5个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            System.out.println("第6个任务加入");
            try {
                Thread.sleep(2000L);
                try {
                    System.out.println(cb.getParties());
                    cb.await();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for(;;) {
            try {
                System.out.println(cb.getParties());
                cb.await();
                System.out.println("任务执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}
