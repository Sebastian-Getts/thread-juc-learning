package com.thread.learning.demo.textbook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sebastian
 * @date 2022/08/2022/8/27 19:02
 */
public class ExecutorDemo {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 将为每一个等待的任务创建一个新的线程，会并发执行
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintChar('c', 100));
        // 通知执行器关闭，不能接受新的任务，但是现有的任务将继续执行直至完成。
        executor.shutdown();
    }
}
