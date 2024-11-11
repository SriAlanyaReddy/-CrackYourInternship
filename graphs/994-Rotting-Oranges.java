class Pair{
    int first;
    int second;
    int tm;
    Pair(int first,int second,int tm){
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] infected=new boolean[m][n];
        Queue<Pair>q=new LinkedList<>();
        int cntfresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    infected[i][j]=true;
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    cntfresh++;
                }
            }
        }
        int cntinfected=0;
        int[] dx={0,1,0,-1};
        int dy[]={-1,0,1,0};
        int reqtime=0;
        while(!q.isEmpty()){
            int x=q.peek().first;
            int y=q.peek().second;
            int time=q.peek().tm;
            q.remove();
            reqtime=Math.max(time,reqtime);
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(inbound(nx,ny,m,n) && infected[nx][ny]==false && grid[nx][ny]==1){
                    q.offer(new Pair(nx,ny,time+1));
                    infected[nx][ny]=true;
                    cntinfected++;
                }
            }
        }
        return cntinfected==cntfresh?reqtime:-1;
    }
    public static boolean inbound(int i,int j,int rows,int cols){
        if(i>=0 && i<rows && j>=0 && j<cols){
            return true;
        }
        return false;
    }
}