class Solution {
    public int minFallingPathSum(int[][] matrix) {
      

        int rows = matrix.length;
        int cols = matrix[0].length;
        
		int[][] dp=new int[rows][cols];
		for(int j=0;j<cols;j++){
			dp[0][j]=matrix[0][j];
		}
        
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                int leftDiagonal = Integer.MAX_VALUE;
        int up = dp[i-1][j];
        int rightDiagonal = Integer.MAX_VALUE;
                if(j-1>=0){
                    leftDiagonal=dp[i-1][j-1];
                }
               
                if(j+1<matrix[0].length){
                    rightDiagonal=dp[i-1][j+1];
                }
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(leftDiagonal,rightDiagonal));
            }
        }
        // Try starting from each column in the last row
        int minSum=dp[rows-1][0];
        for (int j = 0; j < cols; j++) {
            minSum = Math.min(minSum,dp[rows-1][j] );
        }

        return minSum;
    }
   

      
}