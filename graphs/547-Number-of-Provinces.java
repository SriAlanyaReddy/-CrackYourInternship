class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[]=new boolean[isConnected.length];
        int n=isConnected.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                c++;
            }
        }
       return c;
    }
    public void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            // Check if the node is connected and not yet visited
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}