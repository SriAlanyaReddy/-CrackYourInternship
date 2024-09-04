class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         //using tabulation
         int n=triangle.size();
         int dp[][]=new int[n][n];
         for(int j=0;j<n;j++){
          
            dp[n-1][j]=triangle.get(n-1).get(j);
        }
         
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down=dp[i+1][j]+triangle.get(i).get(j);
                int diagonal=dp[i+1][j+1]+triangle.get(i).get(j);
                dp[i][j]=Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
    public int paths(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=paths(i+1,j,triangle,dp);
        int diagonal=paths(i+1,j+1,triangle,dp);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(down,diagonal);

    }
}
