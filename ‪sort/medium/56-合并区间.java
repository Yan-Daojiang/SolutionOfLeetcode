import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][2];
    
        // 按照数组的第一个元素进行排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });

        int[][] ans = new int[intervals.length][2];
        int index = -1;

        // 分为相离，相交，包含三种情况进行合并
        for (int[] interval : intervals) {
            if (index == -1 || ans[index][1] < interval[0])
                ans[++index] = interval;
            else 
                ans[index][1] = Math.max(interval[1], ans[index][1]);
        }

        return Arrays.copyOf(ans, index + 1);
    }
}
// @lc code=end

