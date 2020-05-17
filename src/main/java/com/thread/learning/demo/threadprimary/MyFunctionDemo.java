package com.thread.learning.demo.threadprimary;

import io.micrometer.core.instrument.util.JsonUtils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * 消费型: Consumer
 * 供给型: Supplier
 * 函数型: Function
 * 断定: Predicate
 *
 * @author sebastian
 * @date 2020/5/17 16:48
 */
public class MyFunctionDemo {
    public static void main(String[] args) {
        supply();
    }

    /**
     * 供给型接口，无入参，有出参，类型自定义
     */
    private static void supply() {
        Supplier<String> supplier = () -> {
            return "hello";
        };
        System.out.println(supplier.get());
    }

    /**
     * 消费型，有入参，无出参
     */
    private static void consumer() {
        Consumer<String> consumer = s -> {
            System.out.println("bingo");
        };
        consumer.accept("wow");
    }

    /**
     * 有一个入参，返回true or false
     */
    private static void predicated() {
        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test("nice"));
    }

    /**
     * 有入参和出参，类型自定义
     */
    private static void functional() {
        Function<String, Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("abc"));
    }

}


interface BoolInterface {

    public boolean isOk(String str);

    public int myInt(int i);

    public int myString(String s);
}
