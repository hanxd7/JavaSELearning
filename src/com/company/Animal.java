package com.company;

public abstract class Animal {
    abstract public void shoot();
    public void run(){
        System.out.println("run...");
    }

    public static void main(String[] args) {
        //new Animal();抽象类不能实例化
    }
}
class Dog extends Animal{
    //子类必须提供抽象方法的实现
    @Override
    public void shoot() {
        System.out.println("哇偶");
    }
}
