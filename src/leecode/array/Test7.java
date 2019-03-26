package leecode.array;

/**
 * 加一
 * create by toonew on 2018/7/20
 */
public class Test7 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        Test7 test7 = new Test7();
        arr = test7.plusOne(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private int[] plusOne(int[] digits) {
        int i = digits.length;
        while (i > 0) {
            int temp = digits[i - 1] + 1;
            if (temp == 10) {
                digits[i - 1] = 0;
                if (i == 1) {
                    int[] arr = new int[digits.length + 1];
                    System.arraycopy(digits, 0, arr, 1, digits.length);
                    arr[0] = 1;
                    return arr;
                }
            } else {
                digits[i - 1] += 1;
                break;
            }
            i--;
        }
        return digits;
    }
}
