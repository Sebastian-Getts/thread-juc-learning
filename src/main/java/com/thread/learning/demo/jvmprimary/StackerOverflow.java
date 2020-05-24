package com.thread.learning.demo.jvmprimary;

/**
 * Exception in thread "main" java.lang.StackOverflowError
 * StackOverflowError属于错误（根据api文档）
 *
 * @author sebastian
 * @date 24/05/2020 20:33
 **/
public class StackerOverflow {
    public static void stacker() {
        stacker();
    }

    public static void main(String[] args) {
        System.out.println("==============start...");
        stacker();
        System.out.println("==============end ...");
    }
}


