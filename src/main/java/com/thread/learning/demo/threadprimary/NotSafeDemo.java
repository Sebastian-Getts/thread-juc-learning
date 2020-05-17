package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 举例线程不安全 i.e. ArrayList，同理set, map
 *
 * @author sebastian
 * @date 2020/5/17 10:17
 */
@Slf4j
public class NotSafeDemo {

    /**
     * 线程很多时会有ConcurrentModificationException异常;
     * <p>
     * ArrayList线程不安全，导致数据不一致。
     * </p>
     *
     * @param args args
     */
    public static void main(String[] args) {
        juc();
    }

    private static void notSafe() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                // 一边写一边读
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * add方法加了synchronized，虽然线程安全，但是同一时间只能有一个线程访问，读取效率下降
     */
    public static void vector() {
        List<String> list = new Vector<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 一边写一边读
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public static void collections() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 一边写一边读
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * java.util.concurrent
     * 写时复制
     * 底层数object数组，添加时不直接在当前容器object[]加，而是先copy一份，在新的容器加，然后再改变引用指向新的容器。
     * 可以并发地读，用到了读写分离的思想，读写不同的容器。
     */
    public static void juc() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                // 一边写一边读
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
