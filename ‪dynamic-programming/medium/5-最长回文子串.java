/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
            return "";
        
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 0; len < s.length(); ++len) {
            for (int i = 0; i + len < s.length(); ++i) {
                if (len == 0)
                    dp[i][i] = true;
                else if (len == 1)
                     dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
                else 
                    dp[i][i + len] = (s.charAt(i) == s.charAt(i + len)) && dp[i + 1][i + len - 1];
            
                if (dp[i][i + len] && ans.length() < len + 1)
                    ans = s.substring(i, i + len + 1);
            }
        }

        return ans;
    }
}
// @lc code=end

