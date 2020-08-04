package com.company;

public class TestAnonymousInnerClass {
    public static void test01(AA a){
        a.aa();
    }

    public static void main(String[] args) {
        TestAnonymousInnerClass.test01(new AA() {
            @Override
            public void aa() {
                System.out.println("匿名内部类对于接口的实现");
            }
        });
    }
}
interface AA{
    void aa();
}
