package leetcode.sort;

/**
 * 合并两个有序数组
 *
 * @author toonew on 2018/7/27
 */
public class Test1 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        boolean sort = true;
        if (nums1[0] > nums1[1]) {
            sort = false;
        }

        if (sort) {

            int i = 0;
            int j = 0;
            for (; i < nums1.length; i++) {
                for (; j < nums2.length; j++) {
                    if (nums1[i] > nums2[j]) {
                        break;
                    }
                }
            }

            System.out.println(i + "" + j);
        } else {

        }

    }
}
