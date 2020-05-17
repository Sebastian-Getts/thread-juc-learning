package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读-读可以共存并发
 * 读-写 pass
 * 写-写 pass
 *
 * @author sebastian
 * @date 2020/5/17 15:35
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI1 = i;
            new Thread(() -> {
                myCache.get(finalI1 + "");
            }, String.valueOf(i)).start();
        }
    }
}


@Slf4j
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            log.info("{} write data ...", Thread.currentThread().getName());
            map.put(key, value);
            log.info("{} write successfully ...", Thread.currentThread().getName());
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            log.info("{} get data ...", Thread.currentThread().getName());
            log.info("{} get successfully ...the value is {}", Thread.currentThread().getName(), map.get(key));
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
