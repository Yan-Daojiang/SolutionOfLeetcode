/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [面试01.05] 一次编辑距离
 */

// @lc code=start
class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null)
            return true;
        
        // 两个字符串的长度相等时逐个进行判断
        if (first.length() == second.length()) {
            int diff = 0;
            for (int i = 0; i < first.length(); ++i) {
                if (first.charAt(i) != second.charAt(i))
                    ++diff;

                if (diff >= 2)
                    return false;
            }
            return true;
        } // if

        // 两个字符串的长度相差1时，碰到不相等位置长串指针后移2步
        else if (Math.abs(first.length() - second.length()) == 1) {
            int i = 0, j = 0;
            int diff = 0;
            while (i < first.length() && j < second.length()) {
                if (first.charAt(i) != second.charAt(j)) {
                    ++diff;
                    if (diff >= 2)
                        return false;
                    if (first.length() > second.length())
                        ++i;
                    else 
                        ++j;
                }
                else if (first.charAt(i) == second.charAt(j)) {
                    ++i; 
                    ++j;
                }
            } // while
            return true;
        } 
        return false;
    }
}
// @lc code=end

