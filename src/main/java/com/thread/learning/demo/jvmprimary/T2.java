package com.thread.learning.demo.jvmprimary;

import java.util.concurrent.TimeUnit;

/**
 * JMM有可见性，即通知机制
 *
 * @author sebastian
 * @date 24/05/2020 17:37
 **/
public class T2 {
    public static void main(String[] args) {
        TempNumber tempNumber = new TempNumber();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tempNumber.change();
            System.out.println(Thread.currentThread().getName() + " changed number and now it is " + tempNumber.number);
        }, "AAA").start();
        while (tempNumber.number == 10) {

        }
        System.out.println(Thread.currentThread().getName() + "'s mission is over, number is " + tempNumber.number);
    }
}

class TempNumber {
    // 具备对其他线程的可见通知性，更改后会通知其他线程。
    volatile int number = 10;

    public void change() {
        this.number = 23;
    }
}
