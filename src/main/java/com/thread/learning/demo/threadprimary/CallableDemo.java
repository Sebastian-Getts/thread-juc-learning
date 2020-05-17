package com.thread.learning.demo.threadprimary;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 与runnable接口的区别
 * 返回值、抛异常、落地方法
 * <p>
 * 多态
 * <p>
 * 作为耗时较长的工作去执行，完成后获取结果，避免长时间等待造成堵塞。
 * 缓存机制，多个线程调用futureTask，也只执行一次。
 *
 * @author sebastian
 * @date 2020/5/17 11:18
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable {

    @Override
    public Integer call() {
        System.out.println("Hello, I'm Callable ...");
        return 1024;
    }
}
