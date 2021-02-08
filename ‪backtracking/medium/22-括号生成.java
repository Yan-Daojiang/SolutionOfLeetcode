import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0)
            return ans;
        
        generate(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    private void generate(StringBuilder currString, int left, int right, int max, List<String> ans) {
        if (currString.length() == max * 2) {
            ans.add(currString.toString());
            return ;
        }

        if (left < max) { // 能够继续添加左括号
            currString.append('(');
            generate(currString, left + 1, right, max, ans);
            currString.deleteCharAt(currString.length() - 1);
        }
        if (right < left) { // 能够添加有括号
            currString.append(')');
            generate(currString, left, right + 1, max, ans);
            currString.deleteCharAt(currString.length() - 1);
        }
    }
}
// @lc code=end

