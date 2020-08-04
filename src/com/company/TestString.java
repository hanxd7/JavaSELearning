package com.company;

public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a"+"bc";//使用了常量池里的对象
        String s3 = new String("abc");//创建了新的对象
        System.out.println((s1 == s2));
        System.out.println(s1 == s3);
        System.out.println(s2.charAt(0));
    }

}
