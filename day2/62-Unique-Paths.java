class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
\t for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
\treturn f(m-1,n-1,dp);
    }
    public static int f(int i,int j,int[][] dp){
        if(i==0 && j==0){
\t\t\treturn 1;
\t\t}
\t\tif(i<0 || j<0){
\t\t\treturn 0;
\t\t}
\t\tif(dp[i][j]!=-1){
\t\t\treturn dp[i][j];
\t\t}
\t\tint up=f(i-1,j,dp);
\t\tint left=f(i,j-1,dp);
\t\treturn dp[i][j]=left+up;
}// Write your code here.
\t
}