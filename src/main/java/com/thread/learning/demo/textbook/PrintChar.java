package com.thread.learning.demo.textbook;

/**
 * @author sebastiangetts
 * @date 2022/08/2022/8/27 19:04
 */
public class PrintChar implements Runnable {

    private final char charToPrint;

    private final int times;

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(charToPrint);
        }
    }
}
