class Solution {
    public int[][] generateMatrix(int n) {
        var matrix = new int[n][n];
        var top = 0;
        var bottom = n - 1;
        var left = 0;
        var right = n - 1;
        var count = 1;
        // after each iteration perform a single spiral operation
        while (top <= bottom && left <= right) {
            for (var j = left; j <= right; j++)
                matrix[top][j] = count++;
            top++;
            for (var i = top; i <= bottom; i++)
                matrix[i][right] = count++;
            right--;
            for (var j = right; j >= left; j--)
                matrix[bottom][j] = count++;
            bottom--;
            for (var i = bottom; i >= top; i--)
                matrix[i][left] = count++;
            left++;
        }
        return matrix;
    }
}
