import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int first = 0; first < nums.length &&  nums[first] <= 0; ++first) {
            if (first != 0 && nums[first] == nums[first - 1])
                continue;

            int target = -nums[first];
            int third = nums.length - 1;
            
            if (nums[third] < 0)
                break;

            for (int second = first + 1; second < nums.length; ++second) {
                if (second != first + 1 && nums[second] == nums[second - 1])
                    continue;

                while (second < third &&  nums[second] + nums[third] > target)
                    --third;
                
                if (second == third)
                    break;
                
                if (nums[second] + nums[third] ==  target) {
                    List list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

