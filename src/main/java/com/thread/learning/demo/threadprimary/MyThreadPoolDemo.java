package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程复用；控制最大并发数；管理线程
 * 三种方法：
 * newFixedThreadPool; newSingleThreadExecutor; newCachedThreadPool
 * <p>
 * corePoolSize: 常驻核心线程数
 * maximumPoolSize: 最大线程数
 * keepAliveTime: 多余的空闲线程的存活时间
 * unit: keepLiveTime的单位
 * workQueue: 任务队列，被提交但尚未被执行的任务（阻塞队列）
 * threadFactory: 线程工厂
 * handler: 拒绝策略，队列满了，线程数以达最大时，拒绝。
 *
 * @author sebastian
 * @date 2020/5/17 16:04
 */
@Slf4j
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        // 执行长期任务性能好
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 池中只有一个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 短期异步任务，可自动扩容，不用指定具体数字。
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
//                TimeUnit.SECONDS.sleep(1);
                executorService.submit(() -> log.info("{} now sbumit its task ...", Thread.currentThread().getName()), String.valueOf(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
