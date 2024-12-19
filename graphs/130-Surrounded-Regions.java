class Solution {
    public void solve(char[][] board) {
        int m=board.length;
         if (m == 0) return;
        int n=board[0].length;
        
        boolean visited[][]=new boolean[m][n];
        //firat row
      
         // First and last rows
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && visited[0][i]==false) {
                dfs(visited, 0, i, board);
            }
            if (board[m - 1][i] == 'O'&& visited[m-1][i]==false) {
                dfs(visited, m - 1, i, board);
            }
        }
         for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && visited[i][0]==false) {
                dfs(visited, i, 0, board);
            }
            if (board[i][n-1] == 'O'&& visited[i][n-1]==false) {
                dfs(visited, i, n-1, board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    
    }
    public static void dfs(boolean[][] visited,int i,int j,char[][] board){
       
        if(i<0 || j<0 || i>=board.length|| j>=board[0].length|| visited[i][j]==true || board[i][j]=='X'){
            return;
        }
         visited[i][j]=true;
        dfs(visited,i+1,j,board);
        dfs(visited,i-1,j,board);
        dfs(visited,i,j+1,board);
        dfs(visited,i,j-1,board);
    }
}