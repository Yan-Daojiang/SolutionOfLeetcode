import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    /**
     * 先按照身高降序进行排序，那么排在某个元素前面的个数就是
     * 身高大于等于它的个数，此时在按照第二个属性插入到第k个位置，
     * 那么它的前面必然有k个大于等于它身高的人
     * @param people
     * @return
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] person1, int[] person2) {
                return (person1[0] != person2[0]) ? (person2[0] - person1[0]) : (person1[1] - person2[1]);
            }
        });

        List<int[]> ans = new LinkedList<>();
        for (int[] person : people) 
            ans.add(person[1], person);
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
// @lc code=end

