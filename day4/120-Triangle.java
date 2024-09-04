class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         
         int n=triangle.size();
         int dp[][]=new int[n][n];
         for(int i=0;i<n;i++){
          
            Arrays.fill(dp[i], -1);
        }
         
        return paths(0,0,triangle,dp);
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