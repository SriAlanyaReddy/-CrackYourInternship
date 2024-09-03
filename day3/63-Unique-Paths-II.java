class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m=ob.length;
        int n=ob[0].length;
        int dp[][]=new int[m][n];
         if (ob[0][0] == 1 || ob[m-1][n-1] == 1) {
            return 0;

        }
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
         int t=paths(ob,m-1,n-1,dp);
        return t;
    }
    public int paths(int[][] ob,int i,int j,int[][] dp){
        if(i==0 && j==0)
          return 1;
        if (i<0 || j<0)
          return 0;
        if(i>=0 && j>=0 && ob[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=paths(ob,i-1,j,dp);
        int left=paths(ob,i,j-1,dp);
        return dp[i][j]=up+left;
    }
}