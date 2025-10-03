class Solution {
    public int minPathSum(int[][] grid) {
        // use the following recurrence function below
        // to minimize the path to location i,j is the value at (i,j)
        // added with the minimum sum of the path to (i-1, j) or (i, j-1) as we can only
        // move from left to right
        // minPathSum(i,j) = grid(i,j) + min(minPathSum(i-1,j), minPathSum(i, j-1))
        var dimI = grid.length;
        var dimJ = grid[0].length;

        // create minSums grid containing the min sum path to get to (i,j) location
        var minSums = new int[dimI][dimJ];

        // the location (0,0) is by default the value at (0,0) in the grid since we have
        // to start there and the minimum path to get to (0,0) is the grid(0,0)
        minSums[0][0] = grid[0][0];

        // fill out the first row as the sum of the left neighbouring case plus the
        // current value of the current location
        for (int i = 1; i < dimI; i++) {
            minSums[i][0] = grid[i][0] + minSums[i - 1][0];
        }
        // similarly, fill out the first column the same way the first row was filled
        for (int j = 1; j < dimJ; j++) {
            minSums[0][j] = grid[0][j] + minSums[0][j - 1];
        }

        // starting at location (1,1), start apply the recurrence relation mentioned
        // above:
        // minPathSum(i,j) = grid(i,j) + min(minPathSum(i-1,j), minPathSum(i, j-1))
        for (int i = 1; i < dimI; i++) {
            for (int j = 1; j < dimJ; j++) {
                minSums[i][j] = grid[i][j] + Math.min(minSums[i - 1][j], minSums[i][j - 1]);
            }
        }
        return minSums[dimI - 1][dimJ - 1];
    }
}