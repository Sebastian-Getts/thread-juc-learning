package com.thread.learning.demo.threadprimary;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 1. 标准访问下的两个线程，启动由操作系统决定，先后顺序不一定。
 * synchronized锁的是当前的对象this，不是某个方法。所以不会同时进入类中的方法同时访问多个方法。
 * 2. 资源类中的某个方法暂停若干时间（sleep），不会释放资源。理由同上，同一时间段只会有一个线程进入资源类。
 * <p>
 * 3. 资源类中没有加锁的方法，不需要判断有无加锁，所以不会造成争抢，正常进入。
 * 4. 访问两个资源类，不会造成争抢，顺序随缘执行。
 * <p>
 * 5. 访问资源类中的两个静态同步方法，执行顺序通一二
 * 6. 访问两个资源类中的两个静态同步方法，同上，因为static synchronized锁的是class、模板。
 * <p>
 * 7. 访问资源类中的普通方法和静态同步方法，先执行普通，原因同三四
 * 8. 访问两个资源类中的静态同步和普通方法，先执行普通，原因同三四
 *
 * @author sebastian
 * @date 2020/5/17 9:31
 */
@Slf4j
public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> Phone.sms(), "A").start();
        new Thread(() -> Phone.call(), "B").start();
        new Thread(() -> phone.hello(), "C").start();
    }
}

class Phone {
    public static synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sms ...");
    }

    public static synchronized void call() {
        System.out.println("call ...");
    }

    public void hello() {
        System.out.println("hi ...");
    }
}
