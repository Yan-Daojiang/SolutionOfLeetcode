/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (52.09%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    69K
 * Total Submissions: 132.5K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * S 和 T 只含有小写字母以及字符 '#'。
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int len1 = S.length() - 1;
        int len2 = T.length() - 1;

        int skip1 = 0;
        int skip2 = 0;


        while (len1 >= 0 || len2 >= 0) {
            while (len1 >= 0) {
                if (S.charAt(len1) == '#') {
                    ++skip1;
                    --len1;
                } else if (skip1 > 0) {
                    --skip1;
                    --len1;
                } else {
                    break;
                }
            }

            while (len2 >= 0) {
                if (T.charAt(len2) == '#') {
                    ++skip2;
                    --len2;
                } else if (skip2 > 0) {
                    --skip2;
                    --len2;
                } else {
                    break;
                }
            }

            if (len1 >= 0 && len2 >= 0) {
                if (S.charAt(len1) != T.charAt(len2)) {
                    return false;
                }
            } else {
                if (len1 >= 0 || len2 >= 0) {
                    return false;
                }
            }

            --len1;
            --len2;
        }


        return true;
    }
}
// @lc code=end

