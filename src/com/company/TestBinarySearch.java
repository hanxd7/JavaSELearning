package com.company;

import java.util.Arrays;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {3,1,2,7,4,6,5};
        Arrays.sort(arr);
        System.out.println("下标为："+binarySearch(arr, 6));
    }
    public static int binarySearch(int[] arr,int n){
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid] == n){
                return mid;
            }
            if (arr[mid] > n){
                high = mid-1;
            }
            if (arr[mid] < n){
                low = mid+1;
            }
            System.out.println(arr[mid]);
        }
        return -1;
    }
}
