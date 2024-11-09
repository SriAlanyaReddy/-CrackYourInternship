class Solution {
    public boolean isBipartite(int[][] adj) {
        int V=adj.length;
        int color[]=new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;}
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int colorused,int[] color,int[][] adj){
        
        color[node]=colorused;
        for(int adjnode:adj[node]){
           if(color[adjnode]==-1){
            if(dfs(adjnode,1-color[adjnode],color,adj)==false){
                return false;
            }
        }
            else if(color[adjnode]==color[node]){
                return false;
            }
        }
        return true;
    }
}
