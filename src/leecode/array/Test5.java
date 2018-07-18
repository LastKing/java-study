package leecode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 * create by toonew on 2018/7/19
 */
public class Test5 {

    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 1, 2, 1, 2, 3, 3};

        Test5 test5 = new Test5();
        System.out.println(test5.singleNumber(nums));
    }

    /**
     * 这个异或。。。。神奇。。。
     * 因为相同为0
     */
    private int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = nums[i] ^ result;
        }
        return result;
    }

    private int singleNumber2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    /**
     * 借助map 的生成空间的 方式，不符合题意
     */
    private int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 1 + map.get(nums[i]));
            }
        }

        for (Object o : map.keySet()) {
            if (map.get(o) == 1) {
                return (int) o;
            }
        }

        return 0;
    }

}
