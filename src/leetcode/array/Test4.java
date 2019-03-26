package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * create by toonew on 2018/7/19
 */
public class Test4 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        Test4 test4 = new Test4();
        System.out.println(test4.containsDuplicate(nums));

    }

    private boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.get(nums[i]) == null) {
                map.put(nums[i], true);
            } else {
                return true;
            }
        }
        return false;
    }

}
