class Solution {
    // Preorder function to populate the map
    static void preorder(TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> nodes,
                         int vertical, int level, Node root) {
        if (root == null) {
            return; // Base case: If the node is null, stop recursion.
        }

        // Add the current node's value into the TreeMap
        nodes.putIfAbsent(vertical, new TreeMap<>());
        nodes.get(vertical).putIfAbsent(level, new TreeSet<>());
        nodes.get(vertical).get(level).add(root.data);

        // Recurse for the left and right children
        preorder(nodes, vertical - 1, level + 1, root.left);
        preorder(nodes, vertical + 1, level + 1, root.right);
    }

    // Function to find the vertical order traversal of the Binary Tree
    static ArrayList<Integer> verticalOrder(Node root) {
        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> nodes = new TreeMap<>();
        preorder(nodes, 0, 0, root); // Populate the TreeMap using preorder traversal

        // Prepare the result
        ArrayList<Integer> result = new ArrayList<>();
        for (TreeMap<Integer, TreeSet<Integer>> verticalMap : nodes.values()) {
            for (TreeSet<Integer> levelSet : verticalMap.values()) {
                result.addAll(levelSet); // Add all values from the current level to the result
            }
        }

        return result;
    }
}
