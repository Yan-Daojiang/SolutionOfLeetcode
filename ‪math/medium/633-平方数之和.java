import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Medium (35.35%)
 * Likes:    256
 * Dislikes: 0
 * Total Accepted:    75.8K
 * Total Submissions: 192.3K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 
 * 
 * 示例 2：
 * 
 * 输入：c = 3
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 输入：c = 4
 * 输出：true
 * 
 * 
 * 示例 4：
 * 
 * 输入：c = 2
 * 输出：true
 * 
 * 
 * 示例 5：
 * 
 * 输入：c = 1
 * 输出：true
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= c <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double temp = Math.sqrt(c - i * i);
            if (temp == (int)temp)
                return true;
        }

        return false;
    }
}
// @lc code=end

