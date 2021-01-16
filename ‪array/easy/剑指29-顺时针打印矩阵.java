class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int[] ans = new int[matrix.length * matrix[0].length];
        int index = 0;

        int start = 0;
        while (matrix.length > 2 * start && matrix[0].length > 2* start) {
            int endY = matrix.length - 1 - start;
            int endX = matrix[0].length - 1 - start;

            for (int i = start; i <= endX; ++i) 
               ans[index++] = matrix[start][i];
            
            if (start < endY) 
                for (int i = start + 1; i <= endY; ++i) 
                    ans[index++] = matrix[i][endX];
            
            if (start < endX && start < endY) 
                for (int i = endX -1; i >= start; --i)
                    ans[index++] = matrix[endY][i];
            
            if (start < endX && start < endY - 1)
                for (int i = endY - 1; i >= start + 1; --i)
                    ans[index++] = matrix[i][start];

            ++start; 
        }

        return ans;
    }
}