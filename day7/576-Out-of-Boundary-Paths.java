class Solution {
    private static final int MOD = 1000000007; // For large result overflow

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Memoization array to store the result of subproblems (m x n x maxMove)
        int[][][] dp = new int[m][n][maxMove + 1];
        
        // Initialize dp array with -1 indicating the result has not been computed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        // Call the recursive function with memoization
        return countPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    // Recursive function to count the paths with memoization
    public int countPaths(int m, int n, int remainingMoves, int row, int col, int[][][] dp) {
        // Base case: If out of bounds, this is a valid path
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
        
        // Base case: If no moves left, terminate this branch of recursion
        if (remainingMoves == 0) {
            return 0;
        }
        
        // Check if this subproblem has already been computed
        if (dp[row][col][remainingMoves] != -1) {
            return dp[row][col][remainingMoves];
        }

        // Explore all 4 possible moves (up, down, left, right)
        int up = countPaths(m, n, remainingMoves - 1, row - 1, col, dp);
        int down = countPaths(m, n, remainingMoves - 1, row + 1, col, dp);
        int left = countPaths(m, n, remainingMoves - 1, row, col - 1, dp);
        int right = countPaths(m, n, remainingMoves - 1, row, col + 1, dp);

        // Calculate the total paths and store them in the memoization table (mod MOD)
        dp[row][col][remainingMoves] = ((up + down) % MOD + (left + right) % MOD) % MOD;
        
        return dp[row][col][remainingMoves];
    }
}
