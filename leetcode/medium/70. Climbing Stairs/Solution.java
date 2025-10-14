class Solution {
    public int climbStairs(int n) {
        if (n < 2)
            return 1;
        var fnm1 = 1;
        var fnm2 = 1;
        for (int i = 2; i <= n; i++) {
            var fn = fnm1 + fnm2;
            fnm2 = fnm1;
            fnm1 = fn;
        }
        return fnm1;
    }
}