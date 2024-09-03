class Solution {

    // Method to find the minimum path sum in a grid
    public static int minPathSum(int[][] a) {
        int m = a.length; // Number of rows in the grid
        int n = a[0].length; // Number of columns in the grid
        int[][] dp = new int[m][n]; // DP array to store minimum path sums

        // Initialize the starting point of the DP array
        dp[0][0] = a[0][0]; // Base case: The top-left corner of the grid

        // Initialize the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0]; // Each cell in the first column can only be reached from the cell above
        }

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + a[0][j]; // Each cell in the first row can only be reached from the cell on the left
        }

        // Fill the DP array for the rest of the cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The minimum path sum to cell (i, j) is the value at (i, j) plus the minimum of the path sums from top and left cells
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }

        // Return the minimum path sum to the bottom-right corner of the grid
        return dp[m - 1][n - 1];
    }
}
