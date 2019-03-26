package leecode.array;


/**
 * create by toonew on 2018/7/20
 */
public class Test8 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 1};

        Test8 test8 = new Test8();
        test8.moveZeroes(arr);

        for (int num : arr) {
            System.out.println(num);
        }
    }

    private void moveZeroes(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                i--;
                num++;
                if (num > 1000) break;
            }
        }
    }

}
