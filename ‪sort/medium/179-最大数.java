import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (37.83%)
 * Likes:    470
 * Dislikes: 0
 * Total Accepted:    53K
 * Total Submissions: 139.6K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
 * 
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [10,2]
 * 输出："210"
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1]
 * 输出："1"
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums = [10]
 * 输出："10"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) 
            asStrs[i] = String.valueOf(nums[i]);
        
        Arrays.sort(asStrs, (s1, s2)->(s2 + s1).compareTo(s1 + s2));

        if (asStrs[0].equals("0"))
            return "0";

        StringBuilder ans = new StringBuilder();
        for (String numStr : asStrs) 
            ans.append(numStr);

        return ans.toString();
    }
}
// @lc code=end

