/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
            return s;
        
        String ans = "";

        for (int i = 0; i < s.length(); ++i) {
            int len1 = extendFromCenter(s, i, i);
            int len2 = extendFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (ans.length() < len) 
                ans = s.substring(i - (len - 1) / 2, i + 1  + len / 2);
        }

        return ans;
    }

    private int extendFromCenter(String s, int left, int right) {
        // 从中心扩展找到的一个回文串的最大长度
        if (s == "")
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }
}
// @lc code=end

