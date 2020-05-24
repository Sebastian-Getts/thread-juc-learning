package com.thread.learning.demo.jvmprimary;

/**
 * 先执行静态的，静态类似模板，只加载一次（模板需要一份就行了）。
 * jvm加载优先级：静态的 > 构造块 > 构造方法
 *
 * @author sebastian
 * @date 24/05/2020 17:24
 **/
public class CodeBlock03 {
    {
        //构造块
        System.out.println("code block struct block");
    }

    static {
        System.out.println("code block static struct block");
    }

    public CodeBlock03() {
        System.out.println("code block struct method");
    }

    public static void main(String[] args) {
        System.out.println("==================================");
        new TempCode();
        System.out.println("-----------------------------------");
        new TempCode();
        System.out.println("-----------------------------------");
        new CodeBlock03();
    }
}

class TempCode {
    public TempCode() {
        System.out.println("temp code struct method");
    }

    {
        System.out.println("temp code block struct block");
    }

    static {
        System.out.println("temp code static struct block");
    }


}
