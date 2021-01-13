class Solution {
    public int cuttingRope(int n) {
        // 贪心算法求解
        if (n <= 3)
            return n - 1;
        if (n == 4)
            return n;
        long ans = 1;
        while (n > 4) {
            ans *= 3;
            ans %= (1e9 + 7);
            n -= 3;
        }
        
        // 最后n的值只有可能是：2、3、4。而2、3、4能得到的最大乘积恰恰就是自身值
        return (int)(ans * n % (1e9 + 7));
    }
}