package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 同CountDownLatch，这个是只用await
 *
 * @author sebastian
 * @date 2020/5/17 15:16
 */
@Slf4j
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            log.info("Boooooooooooooooom!");
        });

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(() -> {
                log.info(Thread.currentThread().getName() + "\t collected {} ball ...", finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
