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
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> charStack = new LinkedList<>();

        s = s.trim(); // 头部紧凑:去掉字符串开头的所有空格
        
        int i = 0;
        while (i < s.length()) {
            if (i == 0 && s.charAt(i) == '-') {
                // 如果头部紧凑之后的第一个字符为‘-’则数字栈压入0，字符栈压入'-'
                charStack.push('-');
                numStack.push(0);
                ++i; 
                continue;
            } else if (s.charAt(i) == ' ') {
                // 中间和尾部的空格直接跳过
                ++i;
                continue;
            } else if (s.charAt(i) == '(') {
                charStack.push(s.charAt(i));
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (charStack.isEmpty() || charStack.peek() == '(') {
                    charStack.push(s.charAt(i));
                } else if (charStack.peek() == '+') {
                    numStack.push(numStack.pop() + numStack.pop());
                    charStack.pop();
                    charStack.push(s.charAt(i));
                } else if (charStack.peek() == '-') {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(num2 - num1);
                    charStack.pop();
                    charStack.push(s.charAt(i));
                }
            } else if (s.charAt(i) == ')') {
                while (charStack.peek() != '(') {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    if (charStack.peek() == '+') {
                        numStack.push(num1 + num2);
                    } else if (charStack.peek() == '-') {
                        numStack.push(num2 - num1);
                    }
                    charStack.pop();
                }
                charStack.pop();
            } else {
                int curNum = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    curNum = 10 * curNum + (s.charAt(i) - '0');
                    ++i;
                }
                numStack.push(curNum);
                continue;
            }

            ++i;
        }

        while (!charStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            if (charStack.peek() == '+') {
                numStack.push(num1 + num2);
                charStack.pop();
            } else {
                numStack.push(num2 - num1);
                charStack.pop();
            }
        }

        return numStack.peek();
    }
}
// @lc code=end

