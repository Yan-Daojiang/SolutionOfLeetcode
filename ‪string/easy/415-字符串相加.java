/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null)
            return num1;
        
        StringBuilder ans = new StringBuilder();
        int flag = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int x = (i < num1.length() && i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j < num2.length() && j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int bitSum = (x + y + flag) % 10;
            flag = (x + y + flag) / 10;

            ans = ans.append(bitSum);
        
            --i;
            --j;
        }
        if (flag == 1)
            ans = ans.append(1);

        return ans.reverse().toString();
    }
}
// @lc code=end

