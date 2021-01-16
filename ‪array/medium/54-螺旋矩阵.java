import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        
        if (matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        
        int start = 0;
        while (2 * start < matrix.length && 2 * start < matrix[0].length) {
            int endX = matrix[0].length - 1 - start;
            int endY = matrix.length - 1 - start;

            for (int i = start; i <= endX; ++i)
                list.add(matrix[start][i]);
            
            if (endY > start)
                for (int i = start + 1; i <= endY; ++i)
                    list.add(matrix[i][endX]);
            
            if (start < endX && start < endY)
                for (int i = endX - 1; i >= start; --i)
                    list.add(matrix[endY][i]);
            
            if (start < endX && start < endY - 1)
                for (int i = endY - 1; i >= start + 1; --i)
                    list.add(matrix[i][start]);  
                    
            ++start;
        }

        return list;
    }
}
// @lc code=end

