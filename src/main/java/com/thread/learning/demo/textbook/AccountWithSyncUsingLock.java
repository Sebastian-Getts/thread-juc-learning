package com.thread.learning.demo.textbook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sebastiangetts
 * @date 2022/08/2022/8/27 19:32
 */
public class AccountWithSyncUsingLock {

    private static final Account account = new Account();

    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0; i<100; i++) {
            executor.execute(new AddPennyTask());
        }
        executor.shutdown();
        while(!executor.isTerminated()) {

        }
        System.out.println("What is balance? " + account.getBalance());
    }

    public static class AddPennyTask implements Runnable {

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {

        private static final Lock lock = new ReentrantLock();

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException e) {
                // do nothing
            } finally {
                lock.unlock();
            }
        }
    }
}
