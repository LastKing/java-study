package leetcode.array;

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 * 快慢指针
 * 认真阅读题目：
 * 1. 给定一个 排序过后的 数组
 * 2. 要求原地
 * 3. 要求返回新的非重复数组的长度
 * 4. 要求返回得新的长度对应的位置的数字无重复
 * 5. 并不要求，完全清除数组中所有的数据。。。
 *
 * @author toonew on 2018/6/21
 */
public class Test1 {

    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        int i = removeDuplicates(arr);

        System.out.println(i);

        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }


}
