class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
	 for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
	return f(m-1,n-1,dp);
    }
    public static int f(int i,int j,int[][] dp){
        if(i==0 && j==0){
			return 1;
		}
		if(i<0 || j<0){
			return 0;
		}
		if(dp[i][j]!=-1){
			return dp[i][j];
		}
		int up=f(i-1,j,dp);
		int left=f(i,j-1,dp);
		return dp[i][j]=left+up;
}// Write your code here.
	
}
