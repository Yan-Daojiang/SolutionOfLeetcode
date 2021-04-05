import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1081 lang=java
 *
 * [1081] 不同字符的最小子序列
 *
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/description/
 *
 * algorithms
 * Medium (57.11%)
 * Likes:    91
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 18.9K
 * Testcase Example:  '"bcabc"'
 *
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * 
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "bcabc"
 * 输出："abc"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String smallestSubsequence(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];

        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> deque = new LinkedList<>();
        boolean[] exit = new boolean[26];

        for (int i = 0; i < len; i++) {
            if (exit[charArray[i] - 'a'])
                continue;

            while (!deque.isEmpty() && lastIndex[deque.peekLast() - 'a'] > i && deque.peekLast() > charArray[i]) {
                Character top = deque.pollLast();
                exit[top - 'a'] = false;
            }

            deque.offerLast(charArray[i]);
            exit[charArray[i] - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }


        return ans.toString();
    }
}
// @lc code=end

