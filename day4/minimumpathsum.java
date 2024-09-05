class Solution {
    public int minFallingPathSum(int[][] matrix) {
      

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MAX_VALUE;
		int[][] dp=new int[rows][cols];
		for(int i=0;i<rows;i++){
			Arrays.fill(dp[i],-1);
		}

        // Try starting from each column in the last row
        for (int j = 0; j < cols; j++) {
            maxSum = Math.min(maxSum, pathsum(matrix, rows - 1, j,dp));
        }

        return maxSum;
    }
    public static int pathsum(int[][] matrix, int i, int j,int[][] dp) {
        // Base case: when we are in the first row, return the value at matrix[0][j]
        if (i == 0) {
            return matrix[0][j];
        }

        // Initialize values for leftDiagonal, up, and rightDiagonal
        int leftDiagonal = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        int rightDiagonal = Integer.MAX_VALUE;
        if(dp[i][j]!=-1){
			return dp[i][j];
		}
        // Check if left diagonal exists
        if (j - 1 >= 0) {
            leftDiagonal = pathsum(matrix, i - 1, j - 1,dp);
        }

        // Always exists directly above
        up = pathsum(matrix, i - 1, j,dp);

        // Check if right diagonal exists
        if (j + 1 < matrix[0].length) {
            rightDiagonal = pathsum(matrix, i - 1, j + 1,dp);
        }

        // Return the maximum path sum from the current cell (i, j)
        return dp[i][j]=matrix[i][j] + Math.min(leftDiagonal, Math.min(up, rightDiagonal));
    }
}
