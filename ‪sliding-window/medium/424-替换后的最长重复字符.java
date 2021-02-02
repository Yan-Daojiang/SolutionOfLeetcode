/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() < 2)
            return s.length();

        int length = s.length();
        char[] ch = s.toCharArray();
        int[] count = new int[26];
        int maxCount = 0;

        int res = 0;
        int left = 0, right = 0;
        
        while (right < length) {
            count[ch[right] - 'A']++;
            maxCount = Math.max(maxCount, count[ch[right] - 'A']);
            ++right;
            
            if (right - left > maxCount + k) {
                count[ch[left] - 'A']--;
                left++;
            }

            res = Math.max(res, right - left);  
        }
        
        return res;
    }
}
// @lc code=end

