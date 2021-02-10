import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    private static int SEG_COUNT = 4; // ipv4地址下的IP地址分为4段
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() <= 3)
            return ans;
        
        int[] segments = new int[SEG_COUNT]; // 保存每段的十进制数形式
        
        dfs(s, 0, segments, 0, ans);

        return ans;
    }

    private void dfs(String s, int index, int[] segments, int segNum, List<String> ans) {
        // 完成搜索并且获得每段的十进制数字形式
        if (segNum == SEG_COUNT) {
            if (index == s.length()) {
                StringBuilder currentIP = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    currentIP.append(segments[i]);

                    if (i != SEG_COUNT - 1)
                        currentIP.append(".");
                } // for
                
                ans.add(currentIP.toString());
            } // if

            return;
        } // if

        // 没有找到4段就搜索完了整个字符串
        if (index == s.length()) 
            return;

        if (s.charAt(index) == '0') {
            // 直接确定当前的这段为0
            segments[segNum] = 0;
            dfs(s, index + 1, segments, segNum + 1, ans);
        }

        int addr = 0; // 
        for (int end = index; end < s.length(); end++) {
            addr = addr * 10 + (s.charAt(end) - '0');

            if (addr > 0 && addr <= 255) {
                segments[segNum] = addr;
                dfs(s, end + 1, segments, segNum + 1, ans);
            } else {
                break;
            }
        }

    }
}
// @lc code=end

