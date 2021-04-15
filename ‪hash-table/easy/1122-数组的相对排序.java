import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 *
 * https://leetcode-cn.com/problems/relative-sort-array/description/
 *
 * algorithms
 * Easy (70.81%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    57.8K
 * Total Submissions: 81.7K
 * Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
 *
 * 给你两个数组，arr1 和 arr2，
 * 
 * 
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 
 * 
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1
 * 的末尾。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr1) {
            list.add(num);
        }

        list.sort(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                int arr1 = map.getOrDefault(x, 1001);
                int arr2 = map.getOrDefault(y, 1001);

                if (arr1 != 1001 || arr2 != 1001) {
                    return arr1 - arr2;
                }

                return x - y;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }
}
// @lc code=end

