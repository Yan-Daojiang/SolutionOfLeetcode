/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        
        int minPrices = prices[0];
        int ans = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrices)
                minPrices = prices[i];
            else if (ans < prices[i] - minPrices)
                ans = prices[i] - minPrices;
        }

        return ans;
    }
}
// @lc code=end

