import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 *
 * https://leetcode-cn.com/problems/next-greater-element-iii/description/
 *
 * algorithms
 * Medium (31.29%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    9.1K
 * Total Submissions: 29.1K
 * Testcase Example:  '12'
 *
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * 
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12
 * 输出：21
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 21
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        Deque<Integer> stack = new LinkedList<>();
        // 数字转换为对应的字符数组
        char[] c = ("" + n).toCharArray();
        int len = c.length;

        int index = 0;
        int i = len - 1;
        for (i = len - 1; i >= 0; i--) {
            // 单调栈中维护的是下标
            while (!stack.isEmpty() && c[i] < c[stack.peek()]) {
                index = stack.pop();
            }
            if (index != 0) {
                // 找到了需要进行交换的位置
                swap(c, index, i);
                break;
            }
            stack.push(i);
        }
        if (index == 0)
            return -1;

        Arrays.sort(c, i + 1, len);

        try {
            return Integer.parseInt(new String(c));
        } catch (Exception e) {
            return -1;
        }

    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp; 
    }
}
// @lc code=end

