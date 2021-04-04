/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (32.86%)
 * Likes:    542
 * Dislikes: 0
 * Total Accepted:    63.1K
 * Total Submissions: 192K
 * Testcase Example:  '"1432219"\n3'
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 
 * 注意:
 * 
 * 
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 
 * 
 * 示例 1 :
 * 
 * 
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 
 * 
 * 示例 3 :
 * 
 * 
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {        
        for (int i = 0; i < k; i++) {
            num = remove1digit(num);
        }

        StringBuilder ans = new StringBuilder();
        
        int index = 0;
        while (index < num.length() && num.charAt(index) == '0') { 
                ++index;
        }
        

        for (int i = index; i < num.length(); i++) {
            ans.append(num.charAt(i));
        }

        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }

    private String remove1digit(String num) {
        if (num.length() == 0 || num.length() == 1) 
            return  "0";
        
        StringBuilder str = new StringBuilder(num);
        
        int index = 0;
        for (index = 1; index < num.length(); index++) {
            if (num.charAt(index - 1) > num.charAt(index)) {
                break;
            } 
        }
        
        str.deleteCharAt(index - 1);
        return str.toString();
    }

}
// @lc code=end

