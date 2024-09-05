class Solution {
    public int cherryPickup(int[][] grid) {
         // Create a DP table
         int r=grid.length;
         int c=grid[0].length;
        int[][][] dp = new int[r][c][c];
        
        // Initialize DP table with -1 (indicating uncomputed state)
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return choco(grid, 0, 0, c - 1, dp);
    }
    public static int choco(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: If we're at the last row
        if (i == rows - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // Return the result if already computed
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = Integer.MIN_VALUE;
        int[] dj = {-1, 0, 1};  // Possible moves for columns

        // Explore all possible movements
        for (int dj1 : dj) {
            for (int dj2 : dj) {
                int newJ1 = j1 + dj1;
                int newJ2 = j2 + dj2;

                // Ensure indices are within bounds
                if (newJ1 >= 0 && newJ1 < cols && newJ2 >= 0 && newJ2 < cols) {
                    int currentValue;
                    if (j1 == j2) {
                        currentValue = grid[i][j1] + choco(grid, i + 1, newJ1, newJ2, dp);
                    } else {
                        currentValue = grid[i][j1] + grid[i][j2] + choco(grid, i + 1, newJ1, newJ2, dp);
                    }
                    maxi = Math.max(maxi, currentValue);
                }
            }
        }

        dp[i][j1][j2] = maxi;
        return maxi;
    }
}