package com.question.dictionary;

import java.util.Arrays;

/**
 * 字典算法
 * https://mp.weixin.qq.com/s/_mIeGKdvTOH-1jleJ4aADg
 * create by toonew on 2018/5/8
 */
public class Test {

    private static int[] findNearestNumber(int[] numbers) {
        //拷贝入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);

        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbersCopy);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回自身
        if (index == 0) return null;

        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy, index);

        return numbersCopy;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--)
            if (numbers[i] > numbers[i - 1])
                return i;
        return 0;
    }

    private static void exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--)
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
    }

    private static void reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < 10; i++) {
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    //输出数组
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers)
            System.out.print(i);

        System.out.println();
    }
}
