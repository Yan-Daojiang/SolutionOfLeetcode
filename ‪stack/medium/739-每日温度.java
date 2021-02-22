import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null)
            return new int[0];

        int len = T.length;
        int[] ans = new int[len];

        // 维护一个单调不增的栈
        Deque<Integer> stack = new LinkedList<>();
        
        int i = 0;
        while (i < len) {
            if (stack.isEmpty() || T[i] <= T[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // 确定当前栈顶对应下标需要等待的天数
                int index = stack.peek();
                ans[index] = i - stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }

        return ans;
    }
}
// @lc code=end

