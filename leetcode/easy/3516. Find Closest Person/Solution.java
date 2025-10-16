class Solution {
    public int findClosest(int x, int y, int z) {
        var distX = Math.abs(z - x);
        var distY = Math.abs(z - y);
        if (distX < distY)
            return 1;
        else if (distX > distY)
            return 2;
        else
            return 0;
    }
}