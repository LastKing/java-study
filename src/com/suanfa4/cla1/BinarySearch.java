package com.suanfa4.class1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch1 {

    private static int rank(int key, int[] arr) {
        //数组必须有序
        int lo = 0;
        int aLength = arr.length - 1;

        while (lo <= aLength) {
            int mid = lo + (aLength - lo) / 2;
            if (key < arr[mid]) aLength = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] whiteList = {1, 2, 3, 4};

        Arrays.asList(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0)
                StdOut.println(key);
        }

    }

}
