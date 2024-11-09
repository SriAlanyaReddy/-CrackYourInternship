class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V=adj.size();
        boolean visited[]=new boolean[adj.size()];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(dfs(adj,visited,i,-1)) return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int node,int parent){
        visited[node]=true;
        for(int adjnode:adj.get(node)){
            if(visited[adjnode]==false){
               if(dfs(adj,visited,adjnode,node)==true)
                 return true;
            }
            else if(adjnode!=parent){
                return true;
            }
        }
        return false;
       
    }
}
