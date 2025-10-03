# Partition Equal Subset - Solution Explanation

Please find the [solution](./Solution.java) to the problem here.
First, if the total sum is odd, then you can immediately return false since there's no way to do find equal partitions if the total sum is odd. Even + Even must equal Even.


Next, the key is to create the right memoization 2D array.
Each row represents all the items in `nums[]` up to that index. For example, considering `nums = [1,5,11,5]`, the row `2` represents the subset `[1,5]`. 

The columns represent a target sum. 

Now the dp[i][j] represents the following:

`dp[i][j] = True` if with subset of numbers represented by row `i` is capable of summing the number `j`.
It's ok if not all the numbers are used for the sum.

Knowing this we create a 2D array as mentioned above with the following `len(nums) + 1` rows (to account the first row, the empty subset) and `sum(nums)/2` (half of the total sum).

The recurrence formula is as follows:

```
canPartition(i,j) = canPartition(i-1, j) || canPartition(i-1, j-nums[i-1]) (if j <= nums[i-1])
```
Note here that the index of nums is using `i-1` this is to accomodate from the fact that the rows have one extra row from the empty subset. The subset at row `i` does contain the ith number in nums.

