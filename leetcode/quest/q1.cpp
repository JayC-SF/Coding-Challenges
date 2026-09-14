#include <vector>

class Solution
{
public:
  vector<int> getConcatenation(vector<int> &nums) {
    auto n = nums.size();
    std::vector<int> nums2(n*2);
    for (int i = 0; i < n; i++) {
      nums2[i] = nums[i];
      nums2[i+n] = nums[i];
    }
    return nums2;
  }
}
