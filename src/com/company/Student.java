package com.company;
//javac Student.java java Student 加载类到堆中的方法区
public class Student {
    //属性field
    int id;
    String name;
    int age;
    Computer comp;

    //方法method
    void study(){
        System.out.println("我在认真学习"+comp.brand);
    }
    void play(){
        System.out.println("我在为未来奋斗");
    }
    //构造方法，无参构造方法可以由系统自动创建
    //大小写与类名一样
    //在堆中创建一个对象，属性保持初始值
    Student(){

    }
    //main方法，程序执行的入口
    //在堆中开辟一个main方法的栈帧
    public static void main(String[] args) {
        Student s = new Student(); //通过系统自动创建无参构造方法来创建对象，将堆中的地址赋值给变量
        s.play();
        s.id = 1001;//实质上是对堆中变量的赋值，将方法区中的常量1001赋值给堆中对象的属性
        s.name = "韩旭东";
        s.age = 17;
        Computer c = new Computer();
        c.brand = "华硕";
        s.comp = c;//堆中对象的属性指向另一个堆中的对象
        s.study();

    }

}
//一个java文件可以有多个类，但只能有一个public修饰的类
class Computer{
    String brand;
}