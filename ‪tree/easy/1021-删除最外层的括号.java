/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        String ans = "", tmp = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else 
                stack.pop();
            tmp += ch;
            if (stack.size() == 0) {
                ans += tmp.substring(1, tmp.length() - 1);
                tmp = "";
            }
        }
        return ans;
    }
}
// @lc code=end

