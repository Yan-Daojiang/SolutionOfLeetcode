import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    /**
     * 
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null)
            return new int[0];

        int len = T.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; ++i) {
            ans[i] = 0;
            int j = i;
            while (j < len && T[j] <= T[i])
                ++j;
            
            if (j < len)
                ans[i] = j - i;
        }

        return ans;
    }
}
// @lc code=end

