package leecode.array;

import java.util.*;

/**
 * @author toonew on 2018/7/19
 */
public class Test6 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {2, 2};

        Test6 test6 = new Test6();
        int[] result = test6.intersect(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] l = nums1.length >= nums2.length ? nums1 : nums2;
        int[] r = nums1.length < nums2.length ? nums1 : nums2;
        int[] temp = new int[l.length];

        int i = 0, j = 0, k = 0;

        while (i < l.length && j < r.length) {
            if (l[i] < r[j]) {
                i++;
            } else if (l[i] > r[j]) {
                j++;
            } else {
                temp[k] = l[i];
                i++;
                j++;
                k++;
            }
        }
        int[] result = new int[k];
        System.arraycopy(temp, 0, result, 0, k);

        return result;
    }

    private int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map1.get(nums1[i]);
            map1.put(nums1[i], value == null ? 1 : 1 + value);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) != 0) {
                list.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
