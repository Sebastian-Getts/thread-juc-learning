package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用 i.e.下订单-减库存-调支付
 * 判断-干活-通知
 *
 * @author sebastian
 * @date 2020/5/16 23:26
 */
public class Thread02 {
    public static void main(String[] args) {
        Operate operate = new Operate();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    operate.generateOrder();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    operate.reduceStorage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    operate.pay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}

@Slf4j
class Operate {
    private int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void generateOrder() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            log.info("{} generate order,\tflag is \t{}", Thread.currentThread().getName(), flag);
            flag = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void reduceStorage() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            log.info("{} reduce storage,\tflag is \t{}", Thread.currentThread().getName(), flag);
            flag = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    public void pay() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            log.info("{} is ready to pay,\tflag is \t{}", Thread.currentThread().getName(), flag);
            flag = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
