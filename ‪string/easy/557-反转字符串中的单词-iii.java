/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (73.89%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    116K
 * Total Submissions: 157K
 * Testcase Example:  `"Let's take LeetCode contest"`
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        
        int left = 0;
        int right = 0;

        while (left < s.length()) {
            if (right < s.length() && s.charAt(right) != ' ') {
                ++right;
            } else {
                StringBuilder temp = new StringBuilder(s.substring(left, right));
                ans.append(temp.reverse());
                ans.append(' ');
                left = right + 1;
                right = left;
            }
        }
        
        ans.replace(ans.length() -1 , ans.length(), "");
        return ans.toString();
    }
}
// @lc code=end

