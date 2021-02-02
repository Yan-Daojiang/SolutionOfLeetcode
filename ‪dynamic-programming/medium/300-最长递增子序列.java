/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /**
     * 动态规划
     * 定义dp[i]为以nums[i]结尾(包含nums[i])的最长上升子序列长度，
     * 在计算dp[i]时，已经得到dp[0..i - 1]的值，则状态转移方程为：
     * dp[i] = max(dp[j]) + 1, 其中i > j >= 0且 nums[i] > nums[j]
     * @param nums
     * @return max{dp[i]}
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;
        
        int ans = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1; // 初始化当前的dp[i] 为1；
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
// @lc code=end

