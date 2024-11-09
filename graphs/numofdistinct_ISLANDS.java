class Solution {
    void dfs(int row,int col,int[][] visited, ArrayList<String>vec,int row0,int col0,int[][] grid){
         int n=grid.length;
        int m=grid[0].length;
        visited[row][col]=1;
        vec.add(toString(row-row0,col-col0));
        int delrow[]={-1,0,1,0};
        
        int delcol[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,vec,row0,col0,grid);
            }
        }
    }
    private String toString(int row,int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>> st=new HashSet<>();
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    ArrayList<String>vec=new ArrayList<>();
                    dfs(i,j,visited,vec,i,j,grid);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
}
