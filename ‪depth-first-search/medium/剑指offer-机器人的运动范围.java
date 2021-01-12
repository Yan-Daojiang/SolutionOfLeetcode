class Solution {
    public int movingCount(int m, int n, int k) {
        if (m < 0 || n < 0 || k < 0)
            return 0;

        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i) 
            for (int j = 0; j < n; ++j)
                 visited[i][j] = false; 
        
        return movingCountCore(m, n, k, 0, 0, visited);
    }

    private int movingCountCore(int m, int n, int k, int s, int e, boolean[][] visited) {
        int count = 0;
        if (check(m, n, k, s, e, visited)) {
            visited[s][e] = true;
            count = 1 + movingCountCore(m, n, k, s - 1, e, visited) + movingCountCore(m, n, k, s + 1, e, visited) + movingCountCore(m, n, k, s, e - 1, visited) + movingCountCore(m, n, k, s, e + 1, visited);
        }
        
        return count;
    }

    private boolean check(int m, int n, int k, int s, int e, boolean[][] visited) {
        // 注意这里的s <  m, e < n不能取到等于是因为visited数组是从0计数的
        if (s >= 0 && e >= 0 &&  s < m && e < n && getDigitSum(s) + getDigitSum(e) <= k && visited[s][e] == false)
            return true;

        return false;
    }

    private int getDigitSum(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += (digit % 10);
            digit /= 10;
        }
        return sum;
    }
}