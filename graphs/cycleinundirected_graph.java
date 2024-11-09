class Pair{
    int x;
    int par;
    public Pair(int x,int par){
        this.x=x;
        this.par=par;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V=adj.size();
        boolean visited[]=new boolean[adj.size()];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(Checkforcycle(adj,i,visited)) return true;
            }
        }
        return false;
    }
    public boolean Checkforcycle(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited){
        visited[src]=true;
        int V=adj.size();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node=q.peek().x;
            int parent=q.peek().par;
            q.remove();
            for(int adjnode:adj.get(node)){
                if(visited[adjnode]==false){
                    visited[adjnode]=true;
                    q.add(new Pair(adjnode,node));
                }
                else if(adjnode!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
