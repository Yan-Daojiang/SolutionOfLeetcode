import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏
 */

// @lc code=start
class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;


    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length != 4)
            return false;
        

        List<Double> list = new ArrayList<>();
        for (int num : nums) 
            list.add((double) num);
        
        return slove(list);
    }

    private boolean slove(List<Double> list) {
        if (list.isEmpty())
            return false;

        if (list.size() == 1)
            return (Math.abs(list.get(0) - TARGET)  < EPSILON);
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();

                    // 将剩余的数字添加到list2中
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j)
                            list2.add(list.get(k));
                    }

                    for (int k = 0; k < 4; k++) {
                        // 乘法和加法交换律
                        if (k < 2 && i > j)
                            continue;

                        if (k == ADD) 
                            list2.add(list.get(i) + list.get(j));

                        else if (k == MULTIPLY) 
                            list2.add(list.get(i) * list.get(j));

                        else if (k == SUBTRACT) 
                            list2.add(list.get(i) - list.get(j));

                        else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) 
                                continue;
                            else 
                                list2.add(list.get(i) / list.get(j));
                        }

                        if (slove(list2))
                            return true;

                        list2.remove(list2.size() - 1);
                    } // for
                }
            }
        }

        return false;
    }
}
// @lc code=end

