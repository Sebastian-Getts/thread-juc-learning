package com.thread.learning.demo.jvmprimary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sebastian
 * @date 24/05/2020 21:18
 **/
@Slf4j
public class TransferValue {
    public void changeValue1(int age) {
        age = 60;
    }

    public void changeValue2(Person person) {
        person.setName("Sebastian");
    }

    public void changeValue3(String str) {
        str = "xyz";
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        int age = 20;
        transferValue.changeValue1(age);
        log.info("==I think it is 20, =age: {}", age);

        Person person = new Person("Venezza", 23);
        transferValue.changeValue2(person);
        log.info("I think it is Sebastian, person's name: {}", person.getName());

        String str = "abc";
        transferValue.changeValue3(str);
        log.info("I think it is abc, str is {}", str);
    }
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Person {
    String name;
    int age;
}
