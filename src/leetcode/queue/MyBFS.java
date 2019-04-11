package leetcode.queue;


/**
 * @author toonew on 2019-04-11
 */
public class MyBFS {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;


        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            bfs(grid, i - 1, j);
            bfs(grid, i + 1, j);
            bfs(grid, i, j - 1);
            bfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[4][5];
        arr[0] = new char[]{'1', '1', '1', '1', '0'};
        arr[1] = new char[]{'1', '1', '0', '1', '0'};
        arr[2] = new char[]{'1', '1', '0', '0', '0'};
        arr[3] = new char[]{'0', '0', '0', '0', '0'};


        MyBFS myBFS = new MyBFS();
        System.out.println(myBFS.numIslands(arr));

        char[][] arr2 = new char[0][0];
        System.out.println(myBFS.numIslands(arr2));
    }


}
