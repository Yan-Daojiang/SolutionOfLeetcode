/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> buckets = new Stack<Character>();
        buckets.push('#');  // 栈底压入标志
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    buckets.push(c);
                    break;
                case ')':
                    if (buckets.peek() == '(')
                        buckets.pop();
                    else 
                        return false;
                    break;
                case ']':
                    if (buckets.peek() == '[')
                        buckets.pop();
                    else
                        return false;
                    break;
                case '}':
                    if (buckets.peek() == '{')
                        buckets.pop();
                    else
                        return false;
                    break;
            }
        }
        if (buckets.peek() == '#')
            return true;
        else 
            return false;
    }
}
// @lc code=end

