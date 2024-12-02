import java.util.ArrayList;

class Solution {

    // Function to check if Eulerian Circuit exists in the graph
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        
        // Step 1: Create a visited array to track if a vertex has been visited during DFS
        boolean visited[] = new boolean[v];
        
        // Step 2: Perform DFS traversal starting from the first node (0)
        dfs(0, visited, adj);
        
        // Step 3: Check if all vertices with non-zero degree are visited (Graph must be connected)
        // We check each vertex and if any vertex with an edge is not visited, return false (not connected)
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;  // Graph is disconnected (vertex with edges is not visited)
            }
        }

        // Step 4: Check if all vertices have an even degree (necessary for Eulerian circuit)
        // If any vertex has an odd degree, return false
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() % 2 != 0) {
                return false;  // Vertex has odd degree, Eulerian circuit is not possible
            }
        }

        // If both conditions are satisfied, the graph has an Eulerian circuit
        return true;
    }

    // Depth-First Search (DFS) function to traverse the graph
    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited
        visited[node] = true;

        // Explore all the adjacent nodes to the current node
        for (int adjnode : adj.get(node)) {
            // If the adjacent node has not been visited, recurse for that node
            if (!visited[adjnode]) {
                dfs(adjnode, visited, adj);
            }
        }
    }
}
