package com.company;

public class TestStaticInnerClass {
    public static void main(String[] args) {
        Outer2.Inner inner = new Outer2.Inner();//静态内部类不需要创建对象，直接由外部类调用
    }
}
class Outer2{
    static class Inner{

    }
}
