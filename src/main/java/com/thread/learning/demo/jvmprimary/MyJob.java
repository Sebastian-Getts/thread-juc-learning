package com.thread.learning.demo.jvmprimary;

/**
 * 反射，获取类加载器
 *
 * @author sebastian
 * @date 25/05/2020 23:30
 **/
public class MyJob {
    public static void main(String[] args) {
        Object object = new Object();
        // bootstrap类加载器，C++写的， null
        System.out.println(object.getClass().getClassLoader());
        // NPE (NullPointerException)
        System.out.println(object.getClass().getClassLoader().getParent());
        System.out.println(object.getClass().getClassLoader().getParent().getParent());
        System.out.println("==============================================");

        MyJob myJob = new MyJob();
        // 个人定义的类，使用的加载器为AppClassLoader
        System.out.println(myJob.getClass().getClassLoader());
        System.out.println(myJob.getClass().getClassLoader().getParent());
        System.out.println(myJob.getClass().getClassLoader().getParent().getParent());
    }
}
