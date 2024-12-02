class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        //since first node is visited
        dfs(0,visited,rooms);
        for(boolean j:visited){
            if(!j) return false;
        }
        return true;
    }
    public void dfs(int node,boolean[] visited,List<List<Integer>>adj){
        visited[node]=true;
        for(int adjnode:adj.get(node)){
            if(!visited[adjnode]){
                dfs(adjnode,visited,adj);
            }
        }
    }
}
/*The problem can be visualized as a graph traversal problem where:

Each room is a node.
Each key found in a room represents an edge to another node (room).
The task is to traverse the entire graph starting from node 0 and determine if we can reach all nodes (rooms).
We can use Depth First Search (DFS) to explore all the rooms starting from room 0. The goal is to visit all rooms by collecting keys and using them to unlock other rooms. If, after the DFS traversal, all rooms have been visited, then we return true; otherwise, false.*/