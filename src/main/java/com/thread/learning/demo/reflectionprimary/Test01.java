package com.thread.learning.demo.reflectionprimary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * reflect exercise
 *
 * @author sebastian
 * @date 27/05/2020 00:58
 **/
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 一个类在内存中只有一个class对象，类被加载后，类的整个结构都会被封装在class对象中。
        for (int i = 0; i < 5; i++) {
            Class<?> aClass = Class.forName("com.thread.learning.demo.reflectionprimary.User");
            System.out.println(aClass);
            System.out.println(aClass.hashCode());
        }

    }
}

@Setter
@Getter
@ToString
class User {
    private String name;
    private int id;
    private int age;
}
