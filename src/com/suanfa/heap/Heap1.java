package com.suanfa.heap;

/**
 * 堆排序
 * Created by toonew on 2017/3/22.
 */

class MaxHeap<T> {

    private T[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity + 1];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T item) {
        data[count + 1] = item;
        count++;

        shiftUp(count);
    }

    private void shiftUp(int k) {

//        while (data[k / 2] < data[k]) {

//        }
    }

}

public class Heap1 {
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);

        System.out.println(maxHeap.size());
    }
}
