class Solution {
    // Function to detect cycle in a directed graph.
    public boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,int[] visited,
    int[] pathvisited){
        visited[node]=1;
        pathvisited[node]=1;
        for(int adjnode:adj.get(node)){
            if(visited[adjnode]==0){
                if(dfs(adjnode,adj,visited,pathvisited)==true){
                    return true;
                }
            }
            else if(pathvisited[adjnode]==1 &&pathvisited[adjnode]==1){
                return true;
            }
        }
        pathvisited[node]=0;
        return false;
    }
    public boolean isCyclic(int V,ArrayList<ArrayList<Integer>>adj) {
        // code here
        int[] visited=new int[V];
        int[] pathvisited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,pathvisited)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
