package com.thread.learning.demo.threadprimary;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，分别对一个“空调“加一减一，若干轮。
 *
 * @author sebastian
 * @date 2020/5/16 22:29
 */
public class Thread01 {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.plus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airConditioner.minus();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}

/**
 * 资源类
 *
 * @author sebastian
 * @date 2020/5/16 22:33
 */
class AirConditioner {
    private int number = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void plus() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " plus one ...\t" + number);
            number++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void minus() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " minus one ...\t" + number);
            number--;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
