class Solution {
    public void shortestDistance(int[][] mat) {
        int n=mat.length;
        int INF=Integer.MAX_VALUE;
        // Code here
        //floydd warshalll algorithm it is a multisorce shortest path algorithm
        //it is also used to find negative cyscles 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==-1){
                    mat[i][j]=INF;
                }
                if(i==j){
                    mat[i][j]=0;
                }
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[k][j]!=INF && mat[i][k]!=INF)
                    mat[i][j]=Math.min(mat[i][j],mat[k][j]+mat[i][k]);
                }
            }
        }
        
        /*for(int i=0;i<n;i++){
           
                if(mat[i][i]<0){
                   return -1;}}
                
               
            }*/
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==INF){
                    mat[i][j]=-1;
                }
               
            }
        }
    }
}
