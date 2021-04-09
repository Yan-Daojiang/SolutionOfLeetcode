import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 *
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (66.76%)
 * Likes:    232
 * Dislikes: 0
 * Total Accepted:    43.2K
 * Total Submissions: 64.7K
 * Testcase Example:  '"tree"'
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * "tree"
 * 
 * 输出:
 * "eert"
 * 
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * "cccaaa"
 * 
 * 输出:
 * "cccaaa"
 * 
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入:
 * "Aabb"
 * 
 * 输出:
 * "bbAa"
 * 
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        
        StringBuilder ans = new StringBuilder();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2)->(o2.getValue() - o1.getValue()));
        
        for (Map.Entry<Character, Integer> entry : list) {
            ans.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        return String.valueOf(ans);
    }
}
// @lc code=end

