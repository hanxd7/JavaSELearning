package com.company;

import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args) {
        int[] arr = {3,1,2,7,4,6,5};
        for (int i = 0;i<arr.length-1;i++){
            boolean flag = false;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
                System.out.println(Arrays.toString(arr));
            }
            if (!flag){
                break;
            }
        }
    }
}
