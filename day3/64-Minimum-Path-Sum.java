class Solution {
   
      


     public static int minPathSum(int[][] a){
        int m = a.length;
        int n = a[0].length;
        int[][] dp = new int[m][n];
        // Initialize dp array with -1 to indicate uncomputed cells
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return calmin(m - 1, n - 1, a, dp);
    }

    public static int calmin(int i, int j, int[][] a, int[][] dp) {
        // Base case: if we reach the top-left corner
        if (i == 0 && j == 0) {
            return a[i][j];
        }
        
        // Out of bounds cases
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE; // Use a large number to indicate an invalid path
        }
        
        // Return already computed value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        // Recursively calculate path sums from top and left
        int up = calmin(i - 1, j, a, dp);
        int left = calmin(i, j - 1, a, dp);
        
        // Return the minimum path sum to the current cell
        return dp[i][j] = a[i][j] + Math.min(up, left);
    }
}

    
