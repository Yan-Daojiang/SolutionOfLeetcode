import java.util.Deque;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 *
 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (38.80%)
 * Likes:    303
 * Dislikes: 0
 * Total Accepted:    45.6K
 * Total Submissions: 109.6K
 * Testcase Example:  '"3+2*2"'
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 
 * 整数除法仅保留整数部分。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "3+2*2"
 * 输出：7
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = " 3/2 "
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 预处理
        s = s.replace(" ", "");
        s = s.replace("(-", "(0-");

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
            } else if (cur == '+' || cur == '-' || cur == '*' || cur =='/') {
                while (!ch.isEmpty() && ch.peek() != '(') {
                    // 将优先级高的全部进行计算
                    char pre = ch.peek();
                    if (compare(pre, cur)) {
                        // pre的优先级高
                        cal(num, ch);
                    } else {
                        break;
                    }
                }
                ch.push(cur);
           
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

    private boolean compare(char pre, char opt) {
        if (pre == '*' || pre == '/')
            return true;
        if ((pre == '+' || pre == '-') && (opt == '-' || opt == '+'))
            return true;
        return false;
    }

    private void cal(Deque<Integer> num, Deque<Character> ch) {
        int num1 = num.pop();
        int num2 = num.pop();
        if (ch.peek() == '+') {
            num.push(num1 + num2);
        } else if (ch.peek() == '*') {
            num.push(num1 * num2);
        } else if (ch.peek() == '/') {
            num.push(num2 / num1);
        }else {
            num.push(num2 - num1);
        }

        ch.pop();
    }
}
// @lc code=end

