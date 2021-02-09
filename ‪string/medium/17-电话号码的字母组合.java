import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.equals(""))
            return ans;

        Map<Character, String> map = new HashMap<>(){
            private static final long serialVersionUID = 1L;
            {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        dfs(digits, 0, map, ans, new StringBuilder());
        return ans;
    }

    private void dfs(String digits, int index, Map<Character, String> map, List<String> ans, StringBuilder currentString) {
        if (index == digits.length()) {
            ans.add(currentString.toString());
            return ;
        } else {
            char digit = digits.charAt(index);
            String nums = map.get(digit);
            
            for (int i = 0; i < nums.length(); i++) {
                currentString.append(nums.charAt(i));
                dfs(digits, index + 1, map, ans, currentString);
                currentString.deleteCharAt(index);
            }
        }
    }
}
// @lc code=end

