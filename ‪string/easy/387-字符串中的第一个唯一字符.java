import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (51.57%)
 * Likes:    364
 * Dislikes: 0
 * Total Accepted:    169.4K
 * Total Submissions: 328.3K
 * Testcase Example:  '"leetcode"'
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 
 * 
 * 示例：
 * 
 * s = "leetcode"
 * 返回 0
 * 
 * s = "loveleetcode"
 * 返回 2
 * 
 * 
 * 
 * 
 * 提示：你可以假定该字符串只包含小写字母。
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        for (int index = 0; index < s.length(); index++) {
            if (map.get(s.charAt(index)) == 1){
                return index;
            }
        }
        

        return -1;
    }   
}
// @lc code=end

