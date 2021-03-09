import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 *
 * https://leetcode-cn.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (74.27%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    49.3K
 * Total Submissions: 66.4K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3
 * 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0)
            return ans;
        
        int[] hash = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            ++hash[A[0].charAt(i) - 'a'];
        }

        int[] other = new int[26];
        for (int i = 1; i < A.length; i++) {
            Arrays.fill(other, 0);
            for (int j = 0; j < A[i].length(); j++) {
                ++other[A[i].charAt(j) - 'a'];
            };

            for (int index = 0; index < 26; index++) {
                hash[index] = Math.min(hash[index], other[index]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                ans.add(new String("" + (char)('a' + i)));
                --hash[i];
            }
        }

        return ans;
    }
}
// @lc code=end

