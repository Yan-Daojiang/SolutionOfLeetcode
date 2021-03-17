/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 *
 * https://leetcode-cn.com/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (49.99%)
 * Likes:    420
 * Dislikes: 0
 * Total Accepted:    36.1K
 * Total Submissions: 68.3K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE"
 * 的一个子序列，而 "AEC" 不是）
 * 
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ⁠ ^  ^^
 * babgbag
 * ⁠   ^^^
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * s 和 t 由英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        
        int sLength = s.length();
        int tLength = t.length();

        int[][] dp = new int[sLength + 1][tLength + 1];

        for (int i = 0; i < sLength + 1; i++) 
            dp[i][tLength] = 1;
        
        for (int i = 0; i < tLength; i++) 
            dp[sLength][i] = 0;

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = tLength - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    // 相等的时候可以选择进行匹配或者不进行匹配
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
// @lc code=end

