class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( grid[i][j]==1){
                   
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
     public int dfs(int[][] grid,int i,int j){
      if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
        return 0;
      }
      int cnt=1;
      grid[i][j]=0;
     cnt+=dfs(grid,i-1,j);
     cnt+=dfs(grid,i+1,j);
    cnt+=dfs(grid,i,j-1);
    cnt+=dfs(grid,i,j+1);
        return cnt;

     }
}