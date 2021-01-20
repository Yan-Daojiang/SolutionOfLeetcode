import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;

        int left = 0;
        int right = -1;

        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();

        for (left = 0; left < s.length(); left++) {
            if (left != 0) 
                set.remove(s.charAt(left- 1));
            
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
// @lc code=end

