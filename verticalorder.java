class Solution {

    // Tuple class to store node, vertical, and level
    static class Tuple {
        Node node;
        int vertical, level;

        Tuple(Node node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    // Function to find the vertical order traversal of the Binary Tree
    static ArrayList<Integer> verticalOrder(Node root) {
        // TreeMap to store vertical columns with their corresponding nodes
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue to perform level order traversal
        Queue<Tuple> queue = new LinkedList<>();

        // Start with the root node, at vertical 0 and level 0
        queue.offer(new Tuple(root, 0, 0));

        // Perform level order traversal
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            Node node = current.node;
            int vertical = current.vertical;
            int level = current.level;

            // Insert node data into the TreeMap structure
            map.putIfAbsent(vertical, new TreeMap<>());
            map.get(vertical).putIfAbsent(level, new PriorityQueue<>());
            map.get(vertical).get(level).add(node.data);

            // Enqueue left child with updated vertical and level
            if (node.left != null) {
                queue.offer(new Tuple(node.left, vertical - 1, level + 1));
            }
            // Enqueue right child with updated vertical and level
            if (node.right != null) {
                queue.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }

        // Prepare result by iterating over the map and fetching nodes in vertical order
        ArrayList<Integer> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> verticalMap : map.values()) {
            for (PriorityQueue<Integer> nodes : verticalMap.values()) {
                while (!nodes.isEmpty()) {
                    result.add(nodes.poll());
                }
            }
        }

        return result;
    }

    // Helper function to build tree from input
}
