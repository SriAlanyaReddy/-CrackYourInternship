class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length; // Number of rows in the grid
        int n = ob[0].length; // Number of columns in the grid
        int dp[][] = new int[m][n]; // DP table to store the number of unique paths

        // Check if the start or end cell has an obstacle
        // If either is blocked, no path exists
        if (ob[0][0] == 1 || ob[m-1][n-1] == 1) {
            return 0;
        }

        // Initialize the starting cell
        dp[0][0] = 1; // There is exactly one way to be at the starting cell (itself)

        // Initialize the first column
        // For each cell in the first column, if there's an obstacle, set paths to 0
        // Otherwise, inherit the number of paths from the cell above
        for (int i = 1; i < m; i++) {
            if (ob[i][0] == 1) {
                dp[i][0] = 0; // Obstacle, so no paths through this cell
            } else {
                dp[i][0] = dp[i-1][0]; // Inherit the number of paths from the cell above
            }
        }

        // Initialize the first row
        // For each cell in the first row, if there's an obstacle, set paths to 0
        // Otherwise, inherit the number of paths from the cell to the left
        for (int j = 1; j < n; j++) {
            if (ob[0][j] == 1) {
                dp[0][j] = 0; // Obstacle, so no paths through this cell
            } else {
                dp[0][j] = dp[0][j-1]; // Inherit the number of paths from the cell to the left
            }
        }

        // Fill the rest of the dp table
        // For each cell, if there is no obstacle, the number of unique paths to that cell
        // is the sum of the number of paths from the cell directly above and the cell directly left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (ob[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle, so no paths through this cell
                } else {
                    // Sum paths from the top cell and the left cell
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        // Return the number of unique paths to the bottom-right cell
        return dp[m-1][n-1];
    }
}
