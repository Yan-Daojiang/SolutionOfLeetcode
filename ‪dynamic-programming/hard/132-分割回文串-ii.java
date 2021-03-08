import java.sql.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (44.84%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 60.6K
 * Testcase Example:  '"aab"'
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 
 * 返回符合要求的 最少分割次数 。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "a"
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "ab"
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由小写英文字母组成
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] g = new boolean[len][len];

        for (int i = 0; i < len; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) 
                g[i][j] = (s.charAt(i) == s.charAt(j)) && g[i + 1][j - 1];
        }

        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);

        for (int i = 0; i < len; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[len - 1];
    }
}
// @lc code=end

