class Solution {
    public boolean canPartition(int[] nums) {
        // find the sum of the numbers
        var sum = 0;
        for (int num : nums)
            sum += num;

        // check if the sum is odd, if so, return false
        if ((sum & 1) == 1)
            return false;

        sum /= 2;

        // dummy return
        return false;

    }
}