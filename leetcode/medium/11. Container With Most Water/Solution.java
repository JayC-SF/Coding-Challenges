class Solution {
    public int maxArea(int[] height) {
        var i = 0;
        var j = height.length - 1;
        var max = 0;
        while (i < j) {
            var left = height[i];
            var right = height[j];
            var area = (j - i) * (left < right ? left : right);
            max = max > area ? max : area;
            i = left < right ? i + 1 : i;
            j = left < right ? j : j - 1;
        }
        return max;
    }
}