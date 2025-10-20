class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        var remainders = new int[value];
        var n = nums.length;
        for (int i = 0; i < n; i++) {
            // get the positive remainder of nums[i]
            var remainder = (nums[i] % value + value) % value;
            // add the count of remainders to the list
            remainders[remainder]++;
        }
        var minMult = Integer.MAX_VALUE;
        var remainder = -1;
        for (int i = 0; i < value; i++) {
            var currMult = remainders[i];
            if (currMult < minMult) {
                minMult = currMult;
                remainder = i;
            }
        }
        return minMult * value + remainder;
    }
}