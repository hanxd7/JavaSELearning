package com.company;

import java.util.Arrays;

public class TestArrayCopy {
    public static void main(String[] args) {
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[10];
        //删除指定索引位置的元素，本质上是元素的覆盖
        System.arraycopy(s1,3,s1,2,2);//覆盖
        s1[s1.length-1] = null;
        Arrays.stream(s1).forEach(System.out::println);
    }
}
