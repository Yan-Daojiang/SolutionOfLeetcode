/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        
        // 当整数的值大于3时 
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3;
        int max = 0;

        for (int i = 4; i <= n; ++i) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int temp = dp[j] * dp[i -j];
                if (temp > max)
                    max = temp;
                
                dp[i] = max;
            }
        }
        
        return dp[n];
    }
}
// @lc code=end

