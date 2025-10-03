class Solution {
    public boolean canPartition(int[] nums) {
        // recurrence relation:
        // canPartition(i,j) = canPartition(i-1, j) || canPartition(i-1, j-nums[i-1]) (if j <= nums[i])
        // find the sum of the numbers
        var sum = 0;
        for (int num : nums)
            sum += num;
            
        // check if the sum is odd, if so, return false
        if ((sum & 1) == 1)
            return false;

        // we want to find a combination of nums array that sums up to sum/2.
        // Hence the name targetSum
        var targetSum =  sum/2;
        
        // create 2D dp array
        var dp = new boolean[nums.length + 1][targetSum+1];

        // the first column can sum to 0 by not picking any items
        for (var i = 0; i<nums.length; i++)
            dp[i][0] = true;
            
        // with 0 items, cannot sum to target when i>=1
        for (var j = 1; j<dp[0].length; j++)
            dp[0][j] = false;

        for (var i = 1; i<dp.length; i++)
            for (var j = 1; j<dp[0].length; j++) {
                // if the value of the item is smaller than current target j, then consider 
                // taking the item and hoping that current target - item value in the previous row 
                // is summable
                if (nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
            
        return dp[dp.length-1][targetSum];
    }
}