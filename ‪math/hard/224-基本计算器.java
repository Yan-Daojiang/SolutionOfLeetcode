import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (39.08%)
 * Likes:    405
 * Dislikes: 0
 * Total Accepted:    34.4K
 * Total Submissions: 85.4K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "1 + 1"
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 预处理
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");

        Deque<Integer> num = new LinkedList<>();
        num.push(0);
        Deque<Character> ch = new LinkedList<>();

        int index = 0;
        while (index < s.length()) {
            char cur = s.charAt(index);
            if (cur == '(') {
                ch.push(cur);
            } else if (cur == ')') {
                // 计算直到遇到左边的'('
                while (ch.peek() != '(') {
                    cal(num, ch);
                }
                // 弹出左边的'('
                ch.pop();
            } else if (cur == '+' || cur == '-') {
                if (ch.isEmpty() ||ch.peek() == '(') {
                    ch.push(cur);
                } else {
                    cal(num, ch);
                    ch.push(cur);
                }
            } else {
                int curNum = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    curNum = 10 * curNum + (s.charAt(index) - '0');
                    ++index;
                }
                num.push(curNum);
                continue;
            }

            ++index;
        } 

        while (!ch.isEmpty()) {
            cal(num, ch);
        }


        return num.peek();
    } 

    private void cal(Deque<Integer> num, Deque<Character> ch) {
        int num1 = num.pop();
        int num2 = num.pop();
        if (ch.peek() == '+') {
            num.push(num1 + num2);
        } else {
            num.push(num2 - num1);
        }

        ch.pop();
    }
}
// @lc code=end

