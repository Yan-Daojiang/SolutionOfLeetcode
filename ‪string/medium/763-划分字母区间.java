import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 *
 * https://leetcode-cn.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (76.28%)
 * Likes:    481
 * Dislikes: 0
 * Total Accepted:    62.5K
 * Total Submissions: 82K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int len = S.length();

        if (S == null || len == 0)
            return ans;

        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        int start = 0; 
        int end = 0;

        for (int i = 0; i < len; i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }
}
// @lc code=end

