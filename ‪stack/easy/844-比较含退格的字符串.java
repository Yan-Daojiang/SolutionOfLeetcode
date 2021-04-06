import java.util.Deque;
import java.util.LinkedList;

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
        int len1 = S.length();
        int len2 = T.length();

        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();

        for (int i = 0; i < len1; i++) {
            Character c = S.charAt(i);
            if (!stack1.isEmpty() && c == '#') {
                stack1.pollLast();
            } else if (stack1.isEmpty() && c== '#') {
                continue;
            } else {
                stack1.offerLast(c);
            }
        }


        for (int i = 0; i < len2; i++) {
            Character c = T.charAt(i);
            if (!stack2.isEmpty() && c == '#') {
                stack2.pollLast();
            } else if (stack2.isEmpty() && c == '#') {
                continue;
            } else {
                stack2.offerLast(c);
            }
        }

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Character c1 = stack1.pollFirst();
            Character c2 = stack2.pollFirst();

            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

