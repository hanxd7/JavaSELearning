package com.company;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        String[] sarr = {"3","2"};
        System.out.println(Arrays.toString(sarr));//Arrays的静态toString方法
        Arrays.sort(sarr);
        System.out.println(Arrays.toString(sarr));//Arrays的静态toString方法

        System.out.println(Arrays.binarySearch(sarr, "2"));
    }
}
