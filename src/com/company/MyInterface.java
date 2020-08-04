package com.company;

public interface MyInterface {
    String aa = null;
    void test01();
}
class MyClass implements MyInterface{
    //必须实现接口中的方法
    @Override
    public void test01() {
        //aa = "1";
    }
}
