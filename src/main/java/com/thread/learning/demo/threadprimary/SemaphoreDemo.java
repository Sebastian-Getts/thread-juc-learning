package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * 用于多个共享资源的互斥使用；并发线程数的控制
 * acquire 要么信号量减1，要么一直等待
 * release 信号量的值加1，唤醒等待的线程
 *
 * @author sebastian
 * @date 2020/5/17 15:22
 */
@Slf4j
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    log.info("{} got the part ...", Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(3);
                    log.info("{} leaev the seat ...", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
