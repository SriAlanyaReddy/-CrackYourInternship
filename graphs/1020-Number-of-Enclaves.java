class Solution {
    public int numEnclaves(int[][] board) {
          int m=board.length;
         if (m == 0) return 0;
        int n=board[0].length;
        
        boolean visited[][]=new boolean[m][n];
        //firat row
      
         // First and last rows
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 1 && visited[0][i]==false) {
                dfs(visited, 0, i, board);
            }
            if (board[m - 1][i] == 1 && visited[m-1][i]==false) {
                dfs(visited, m - 1, i, board);
            }
        }
         for (int i = 0; i < m; i++) {
            if (board[i][0] == 1 && visited[i][0]==false) {
                dfs(visited, i, 0, board);
            }
            if (board[i][n-1] == 1 && visited[i][n-1]==false) {
                dfs(visited, i, n-1, board);
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && board[i][j]==1){
                   c++;
                }
            }
        }
        return c;
    }
     public static void dfs(boolean[][] visited,int i,int j,int[][] board){
       
        if(i<0 || j<0 || i>=board.length|| j>=board[0].length|| visited[i][j]==true || board[i][j]==0){
            return;
        }
         visited[i][j]=true;
        dfs(visited,i+1,j,board);
        dfs(visited,i-1,j,board);
        dfs(visited,i,j+1,board);
        dfs(visited,i,j-1,board);
    }
}