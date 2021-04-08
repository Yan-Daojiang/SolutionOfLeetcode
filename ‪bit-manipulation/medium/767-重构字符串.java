/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (47.55%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    35.6K
 * Total Submissions: 74.8K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: S = "aab"
 * 输出: "aba"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: S = "aaab"
 * 输出: ""
 * 
 * 
 * 注意:
 * 
 * 
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }

        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        char[] ans = new char[S.length()];

        int oddIndex = 1;
        int evenIndex = 0;
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            while (count[i] > 0 && count[i] <= S.length() / 2 && oddIndex < S.length()) {
                ans[oddIndex] = ch;
                oddIndex += 2;
                count[i]--;
            }

            while (count[i] > 0) {
                ans[evenIndex] = ch;
                evenIndex += 2;
                count[i]--;
            }
        }

        
        return new String(ans);
    }
}
// @lc code=end

