package com.company;

public class TestInnerClass {
    public static void main(String[] args) {
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();//先创建外部类的对象，再创建内部类的对象
    }
}
class Outer{
    private int age = 10;
    public void testOuter(){
        System.out.println(age);
        //name  :外部类无法访问内部类的成员
    }
    class Inner{  //static 静态内部类和非静态内部类 类名为Outer$Inner.class
        public String name = "aa";
        public void show(){
            System.out.println(age);//内部类中可以直接访问外部类的属性
        }
    }
}
