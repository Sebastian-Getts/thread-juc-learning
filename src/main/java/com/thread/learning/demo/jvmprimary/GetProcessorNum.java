package com.thread.learning.demo.jvmprimary;

import java.util.Random;

/**
 * @author sebastian
 * @date 24/05/2020 22:13
 **/
public class GetProcessorNum {
    public static void main(String[] args) {
        byte[] bytes = new byte[40 * 1024];
    }

    private static void generateError() {
        String str = "www.google.com";
        while (true) {
            str += str + new Random().nextInt(999999) + new Random().nextInt(88888888);
        }
    }

    private static void getEquipmentInfo() {
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Returns the maximum amount of memory that the Java virtual machine will attempt to use.
        long l = Runtime.getRuntime().maxMemory();

        // Returns the total amount of memory in the Java virtual machine.
        long l1 = Runtime.getRuntime().totalMemory();

        System.out.println("(-xmx) MAX_MEMORY: " + l + "bytes, " + (l / (double) 1024 / 1024 + "MB"));
        System.out.println("(-xms) TOTAL_MEMORY: " + l1 + "bytes, " + (l1 / (double) 1024 / 1024 + "MB"));
    }
}
