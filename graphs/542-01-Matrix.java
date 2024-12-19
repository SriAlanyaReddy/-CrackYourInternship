class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //we use bfs approach 
        int dirx[]={-1,1,0,0};
        int diry[]={0,0,-1,1};
        Queue<int[]>q=new LinkedList<>();
        int m=mat.length;
        int n=mat[0].length;
        int distance[][]=new int[m][n];
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.add(new int[]{i,j,0});
                }
                else{
                    visited[i][j]=false;
                }
            }
        }
        while(!q.isEmpty()){
            int x=q.peek()[0];
            int y=q.peek()[1];
            int steps=q.peek()[2];
            q.remove();
            distance[x][y]=steps;
            for(int i=0;i<4;i++){
                int nx=x+dirx[i];
                int ny=y+diry[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && visited[nx][ny]==false){
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny,steps+1});
                }
            }

        }
        return distance;
    }
}