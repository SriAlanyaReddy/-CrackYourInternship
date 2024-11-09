class Solution {
    public boolean isBipartite(int[][] adj) {
        int V=adj.length;
        int color[]=new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;}
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(checkforcycle(i,color,adj)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkforcycle(int node,int[] color,int[][] adj){
        
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            int curr=q.peek();
            q.remove();
            for(int adjnode:adj[curr]){
                if(color[adjnode]==-1){
                    color[adjnode]=1-color[curr];
                    q.add(adjnode);
                }
                else if(color[adjnode]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}