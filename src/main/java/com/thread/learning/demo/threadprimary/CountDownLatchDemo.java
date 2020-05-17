package com.thread.learning.demo.threadprimary;

import java.util.concurrent.CountDownLatch;

/**
 * 调用await方法时会堵塞，当计数器为0时会被唤醒。
 *
 * @author sebastian
 * @date 2020/5/17 15:02
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\tleave the room ....");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println("Ok, lock the door ...");
    }
}
