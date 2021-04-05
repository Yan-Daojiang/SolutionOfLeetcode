import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/description/
 *
 * algorithms
 * Medium (47.65%)
 * Likes:    492
 * Dislikes: 0
 * Total Accepted:    51.6K
 * Total Submissions: 108.2K
 * Testcase Example:  '"bcabc"'
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 
 * 注意：该题与 1081
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters
 * 相同
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
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len == 0 || s.length() == 1)
            return s;

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Boolean> exit = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            exit.put(c, false);
        }

        Deque<Character> deque = new LinkedList<>();
        
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            while (!deque.isEmpty() && exit.get(c) == false && deque.peekLast() > c && map.get(deque.peekLast()) > 1) {
                Character temp = deque.pollLast();
                map.put(temp, map.get(temp) - 1);
                exit.put(temp, false);
            }

            if (exit.get(c) == false) {
                deque.offerLast(c);
                exit.put(c, true);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }

        return ans.toString();
    }
}
// @lc code=end

