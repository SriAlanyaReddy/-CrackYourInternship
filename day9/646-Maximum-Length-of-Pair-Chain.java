import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Edge case: if there are no pairs
        if (pairs.length == 0) {
            return 0;
        }

        int n = pairs.length; // Number of pairs
        
        // Sort pairs based on the second element (end) in ascending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize count and the end time of the first selected pair
        int count = 1;
        int lastEndTime = pairs[0][1]; // The end time of the first pair after sorting

        // Iterate through the sorted pairs and select non-overlapping pairs
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > lastEndTime) { // Check if the start time is after the last selected end time
                count++;
                lastEndTime = pairs[i][1]; // Update the end time to the current pair's end
            }
        }

        return count; // Return the maximum number of non-overlapping pairs (longest chain)
    }
}
