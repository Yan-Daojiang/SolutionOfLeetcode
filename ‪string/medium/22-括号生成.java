import java.util.ArrayList;
import java.util.List;

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
        
        generate(new char[2 * n], 0, ans);

        return ans;
    }

    private void generate(char[] currentString, int pos, List<String> ans) {
        if (pos == currentString.length) {
            if (valid(currentString))
                ans.add(new String(currentString));
        } else {
            currentString[pos] = '(';
            generate(currentString, pos + 1, ans);
            currentString[pos] = ')';
            generate(currentString, pos + 1, ans);
        }
    }

    private boolean valid(char[] currentString) {
        int balance = 0;
        for (char ch : currentString) {
            if (ch == '(') 
                ++balance;
            else 
                --balance;
            
            if (balance < 0)
                return false;
        } 

        if (balance == 0)
            return true;
        
        return false;
    }
}
// @lc code=end

