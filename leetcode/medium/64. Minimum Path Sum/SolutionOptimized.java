
public class SolutionOptimized {
    public int minPathSum(int[][] grid) {
        var dp = new int[grid[0].length];

        // set the first value
        dp[0] = grid[0][0];

        // fill out the first row
        for (int j = 1; j < dp.length; j++)
            dp[j] = grid[0][j] + dp[j - 1];

        // use the current row as the previous one and fill out again one
        // by one
        // start at index 1 since the current dp contains the first row (row 0 already)
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < dp.length; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[dp.length - 1];
    }
}
