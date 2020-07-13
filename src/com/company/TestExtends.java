package com.company;

import java.util.Objects;

public class TestExtends {
    public static void main(String[] args) {
        Student1 s = new Student1();
        s.name = "aa";
        System.out.println(s.name);
        Student1 s1 = new Student1();
        System.out.println((new Person() instanceof Object));//不能两个对象相互比较，必须是一个对象一个类
    }
}
class Person{
    String name;
    int age;
    void rest() {
        System.out.println("我们休息一下吧。。");
    }
}
//一个包下不能有同名类
class Student1 extends Person{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return Objects.equals(no, student1.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    String no;
    void study(){
        System.out.println("我们学习一会儿吧！");
    }
    public void rest(){
        System.out.println("起来");
    }
}