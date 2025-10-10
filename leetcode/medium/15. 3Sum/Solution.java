import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            var x = nums[i];
            var j = i + 1;
            var k = nums.length - 1;
            while (j < k) {
                var y = nums[j];
                var z = nums[k];
                var total = x + y + z;
                if (total > 0)
                    k--;
                else if (total < 0)
                    j++;
                else {
                    results.add(Arrays.asList(x, y, z));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return results;
    }
}