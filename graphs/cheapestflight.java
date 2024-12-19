class Solution {

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Adjacency list representation
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]}); // {destination, cost}
        }

        // Distance array to track the minimum cost to reach each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // BFS Queue: {stops, currentNode, cost}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0}); // Initial condition: 0 stops, src node, 0 cost

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stops = current[0];
            int node = current[1];
            int cost = current[2];

            // If stops exceed k, skip processing
            if (stops > k) continue;

            // Explore all adjacent nodes
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                // If a cheaper cost path is found, update distance and enqueue
                if (cost + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = cost + edgeWeight;
                    q.add(new int[]{stops + 1, adjNode, distance[adjNode]});
                }
            }
        }

        // If destination is unreachable, return -1
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
