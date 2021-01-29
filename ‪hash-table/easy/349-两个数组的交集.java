import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1 == null || nums2 == null)
            return new int[0];

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i)
            map.put(nums1[i], false);

        for (int i = 0; i < nums2.length; i++)
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) == false) {
                list.add(nums2[i]);
                map.put(nums2[i], true);
            }
        

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
            ans[i] = list.get(i);

        return ans;    
    }
}
// @lc code=end

