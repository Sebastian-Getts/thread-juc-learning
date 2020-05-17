package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 某些情况下会挂起线程，满足条件时被挂起的线程会被自动唤醒，BlockQueue将这些细节封装起来了
 * 队列
 *
 * @author sebastian
 * @date 2020/5/17 15:51
 */
@Slf4j
public class BlockQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        log.info(blockingQueue.remove());
    }
}
