import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (47.55%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    35.6K
 * Total Submissions: 74.8K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: S = "aab"
 * 输出: "aba"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: S = "aaab"
 * 输出: ""
 * 
 * 
 * 注意:
 * 
 * 
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }

        if (maxCount > (S.length() + 1) / 2)
            return "";

        StringBuilder ans = new StringBuilder();
        
        PriorityQueue<Character> heap = new PriorityQueue<>((o1, o2)->(count[o2 - 'a'] - count[o1 - 'a']));
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] > 0) {
                heap.offer(ch);
            }
        }

        while (heap.size() > 1) {
            Character letter1 = heap.poll();
            Character letter2 = heap.poll();

            ans.append(letter1);
            ans.append(letter2);

            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';

            --count[index1];
            --count[index2];

            if (count[index1] > 0) {
                heap.offer(letter1);
            }

            if (count[index2] > 0) {
                heap.offer(letter2);
            }
        }

        if (heap.size() > 0) {
            ans.append(heap.poll());
        }

        return ans.toString();
    }
}
// @lc code=end

