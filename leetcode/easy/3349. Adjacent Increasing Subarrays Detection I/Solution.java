import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        var n = nums.size();
        var a = 0;
        var c = 2 * k - 1;
        for (a = 0; c < n; a++) {

            var isIncreasing = true;
            var b = a + k;
            for (int i = 0; a + i + 1 < b; i++) {
                if (nums.get(a + i) >= nums.get(a + i + 1)) {
                    isIncreasing = false;
                    break;
                }
            }

            if (isIncreasing) {
                for (int i = 0; b + i + 1 <= c; i++) {
                    if (nums.get(b + i) >= nums.get(b + i + 1)) {
                        isIncreasing = false;
                        break;
                    }
                }
            }
            if (isIncreasing)
                return true;
            c = a + 2 * k;
        }
        return false;
    }
}