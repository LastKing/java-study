package leecode.digui;

/**
 * @author toonew on 2018/7/20
 */
public class Test {
    static int[][] arr = new int[4][4];


    public static void main(String[] args) {

        arr[0] = new int[]{0, 1, 1, 0};
        arr[1] = new int[]{2, 1, 2, 1};
        arr[2] = new int[]{1, 1, 2, 1};
        arr[3] = new int[]{0, 1, 1, 0};

        fillColor(arr, 1, 1, 5, 4, 4);

        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println(arr);
    }


    private static void fillColor(int[][] arr, int i, int j, int c, int m, int n) {

        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return;
        }

        int tempColor = arr[i][j];
        arr[i][j] = c;

        if (i - 1 >= 0) {
            if (arr[i - 1][j] == tempColor) {
                fillColor(arr, i - 1, j, c, m, n);
            }
        }

        if (i + 1 <= m - 1) {
            if (arr[i + 1][j] == tempColor) {
                fillColor(arr, i + 1, j, c, m, n);
            }
        }

        if (j - 1 >= 0) {
            if (arr[i][j - 1] == tempColor) {
                fillColor(arr, i, j - 1, c, m, n);
            }
        }

        if (j + 1 <= m - 1) {
            if (arr[i][j + 1] == tempColor) {
                fillColor(arr, i, j + 1, c, m, n);
            }
        }

    }
}
