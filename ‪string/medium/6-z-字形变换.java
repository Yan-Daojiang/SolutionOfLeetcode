import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (49.50%)
 * Likes:    1032
 * Dislikes: 0
 * Total Accepted:    218.3K
 * Total Submissions: 439.7K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0 || s.equals(""))
            return "";
        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int index = 0; index < numRows; index++)
            rows.add(new StringBuilder());

        int flag = -1;
        int i = 0;
        for (char ch : s.toCharArray()) {
            rows.get(i).append(ch);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder currRow : rows)
            ans.append(currRow);

        return ans.toString();
    }
}
// @lc code=end

