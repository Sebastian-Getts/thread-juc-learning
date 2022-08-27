package com.thread.learning.demo.textbook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sebastiangetts
 * @date 2022/08/2022/8/27 19:22
 */
public class AccountWithoutSync {

    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddPennyTask());
        }
        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
            // do nothing
        }
        System.out.println("What is balance? " + account.getBalance());
    }

    private static class AddPennyTask implements Runnable {

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
//            int newBalance = balance + amount;
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                // do nothing
//            }
//            balance = newBalance;
            balance += amount;
        }
    }
}
