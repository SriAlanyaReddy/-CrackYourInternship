import java.util.ArrayList;

class Solution {
    
    // Function to check if Eulerian Circuit exists
    public boolean isEulerianCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Check for connectivity
        boolean visited[] = new boolean[v];
        dfs(0, visited, adj);
        
        // Ensure all vertices with edges are visited
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;  // Not connected
            }
        }

        // Check if all vertices have even degree
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() % 2 != 0) {
                return false;  // Odd degree, not Eulerian Circuit
            }
        }

        return true;  // Eulerian Circuit exists
    }

    // Function to check if Eulerian Path exists
    public boolean isEulerianPathExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Check for connectivity
        boolean visited[] = new boolean[v];
        dfs(0, visited, adj);
        
        // Ensure all vertices with edges are visited
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;  // Not connected
            }
        }

        // Count vertices with odd degree
        int oddCount = 0;
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() % 2 != 0) {
                oddCount++;
            }
        }

        // Eulerian Path exists if exactly two vertices have odd degree
        return (oddCount == 2);
    }

    // DFS function to check connectivity
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode, visited, adj);
            }
        }
    }
}
