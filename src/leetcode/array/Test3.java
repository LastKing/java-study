package leetcode.array;

/**
 * @author toonew on 2018/6/22
 */
public class Test3 {

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0 || k > nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                break;
            }

            int temp = nums[k - i - 1];
            nums[k - i - 1] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        rotate(arr, 3);

        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }

}
