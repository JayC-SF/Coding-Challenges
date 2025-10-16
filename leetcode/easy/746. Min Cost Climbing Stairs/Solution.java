class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // recurrence formula
        // f(i) = min(f(i-1), f(i-2)) + cost(i)
        if (cost.length <= 0)
            return 0;
        else if (cost.length <= 1)
            return cost[0];
        var fm2 = cost[0];
        var fm1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            var f = Math.min(fm1, fm2) + cost[i];
            fm2 = fm1;
            fm1 = f;
        }
        return Math.min(fm1, fm2);
    }
}