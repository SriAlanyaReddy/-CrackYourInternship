/*Shortest Distance in a Binary Maze
Difficulty: MediumAccuracy: 58.22%Submissions: 69K+Points: 4
Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 

If the path is not possible between source cell and destination cell, then return -1.

Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right. The source and destination cell are based on the zero based indexing. The destination cell should be 1.*/

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] dest) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int INF=Integer.MAX_VALUE;
        if(source[0]==dest[0] && dest[1]==source[1])return 0;
        int dirx[]={1,-1,0,0};
        int diry[]={0,0,1,-1};
        int distance[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=INF;
            }
        }
        distance[source[0]][source[1]]=0;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{0,source[0],source[1]});
        while(!q.isEmpty()){
            int dist=q.peek()[0];
            int x=q.peek()[1];
            int y=q.peek()[2];
            q.remove();
            for(int i=0;i<4;i++){
                int nx=x+dirx[i];
                int ny=y+diry[i];
                
                if(nx<n && ny<m && nx>=0 && ny>=0 && grid[nx][ny]==1 && 1+dist<distance[nx][ny]){
                    distance[nx][ny]=1+dist;
                    if(nx==dest[0] && ny==dest[1]) return dist+1;
                    q.add(new int[]{dist+1,nx,ny});
                    
                }
            }
        }
        return -1;
        
    }
}
