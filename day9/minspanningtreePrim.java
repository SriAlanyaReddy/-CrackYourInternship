class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int sum = 0;

        // Start from the first vertex (0)
        pq.add(new Pair(0, 0));
        int[] visited = new int[V];

        while (!pq.isEmpty()) {
            int weight = pq.peek().distance;
            int vertex = pq.peek().node;
            pq.remove();

            // If the vertex is already visited, continue to the next iteration
            if (visited[vertex] == 1) {
                continue;
            }

            // Add the weight to the sum
            sum += weight;
            visited[vertex] = 1; // Mark the vertex as visited

            // Iterate through the adjacency list of the current vertex
            for (int i = 0; i < adj.get(vertex).size(); i++) {
                int v = adj.get(vertex).get(i)[0]; // Get the adjacent vertex
                int edge = adj.get(vertex).get(i)[1]; // Get the edge weight

                // If the adjacent vertex is not visited, add it to the priority queue
                if (visited[v] == 0) {
                    pq.add(new Pair(v, edge));
                }
            }
        }

        return sum; // Return the total weight of the MST
    }

    
