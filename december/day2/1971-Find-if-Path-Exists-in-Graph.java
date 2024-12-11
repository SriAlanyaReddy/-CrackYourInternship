class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean visited[]=new boolean[n];
        return findPath(adj,source,destination,visited);
    }
    public boolean findPath(List<List<Integer>>adj,int source,int destination,boolean[] visited){
        if(source==destination){
            return true;
        }
        visited[source]=true;
        for(int adjnode:adj.get(source)){
            if(!visited[adjnode] && findPath(adj,adjnode,destination,visited)){
                return true;
            }
        }
        return false;
    }
}