package com.thread.learning.demo.threadprimary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 偶数ID，年龄小于20，用户名转为大写，用户名字母倒序，只输出一个用户名
 * filter: 过滤
 * map: 转化
 *
 * @author sebastian
 * @date 2020/5/17 16:40
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "Jay", 67);
        User u2 = new User(12, "manny", 12);
        User u3 = new User(13, "Gloria", 34);
        User u4 = new User(14, "luk", 11);
        User u5 = new User(15, "Lili", 8);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        list.stream()
                .filter(t -> t.getId() % 2 == 0)
                .filter(t -> t.getAge() < 20)
                .map(m -> m.getUserName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
    }

    public static void map() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list = list.stream().map(x -> x * 2).collect(Collectors.toList());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String userName;
    private int age;
}
