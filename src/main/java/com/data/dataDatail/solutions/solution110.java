package com.data.dataDatail.solutions;

/**
 * @Auther: ljh
 * @Date: 2018/12/17 14:47
 * @Description: 最小路径和
 */
public class solution110 {


    public static int minPathSum(int[][] grid) {
        // write your code here
        if (grid.length == 0 || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < N; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        return sum[M - 1][N - 1];
    }

    public static void main(String[] args) {

        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println( minPathSum(grid));
    }
}
