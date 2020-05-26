package com.thread.learning.demo.reflectionprimary;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 获取类的方法
 *
 * @author sebastian
 * @date 27/05/2020 01:11
 **/
public class ClassStructWays {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("This is " + person.name);

        // method1: by object
        Class<? extends Person> aClass = person.getClass();
        System.out.println(aClass.hashCode());

        // method2: by forname
        Class<?> aClass1 = Class.forName("com.thread.learning.demo.reflectionprimary.Student");
        System.out.println(aClass1.hashCode());

        // method3: by xx.class
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.hashCode());

        // method4: java primary wrap class
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        // get father type
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }
}


@NoArgsConstructor
@AllArgsConstructor
@ToString
class Person {
    public String name;
}

class Student extends Person {

    public Student() {
        this.name = "Student";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "Teacher";
    }
}