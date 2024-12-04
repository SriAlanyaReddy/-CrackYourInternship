class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        // Result list to store all subsets
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sort the array to handle duplicates
        Arrays.sort(a);
        
        // Call the recursive function with initial values
        generateSubsets(a, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void generateSubsets(int[] a, int index, List<Integer> temp, List<List<Integer>> ans) {
        // Add the current subset to the answer
        ans.add(new ArrayList<>(temp));
        
        // Generate all subsets starting from the current index
        for (int i = index; i < a.length; i++) {
            // Skip duplicates
            if (i > index && a[i] == a[i - 1]) {
                continue;
            }
            
            // Include the current element
            temp.add(a[i]);
            generateSubsets(a, i + 1, temp, ans);
            
            // Backtrack to explore other possibilities
            temp.remove(temp.size() - 1);
        }
    }
}
