class Solution {
    public int uniquePaths(int m, int n) {
    int dp[][]=new int[m][n];
\tfor (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1;
    }

\t//The first row and the first column are set to 1 because there's only one way to reach any cell in these locations: by moving right or down from the start.

\tfor(int i=1;i<m;i++){
\t\tfor(int j=1;j<n;j++){
\t\t\tdp[i][j]=dp[i-1][j]+dp[i][j-1];
\t\t}
\t}
\treturn dp[m-1][n-1];
    }
   
\t
}