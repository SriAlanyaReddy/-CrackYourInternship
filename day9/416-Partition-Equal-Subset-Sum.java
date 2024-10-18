class Solution {
    public boolean canPartition(int[] a) {
        int s=0;
        int n=a.length;
\t\tfor(int i=0;i<n;i++){
\t\t\ts+=a[i];
\t\t}
\t\tif(s%2!=0){
\t\t\treturn false;
\t\t}
\t\treturn subsetSumToK(n,s/2,a);
    }
    public static boolean subsetSumToK(int n, int k, int[] arr) {
\t\tboolean dp[][] = new boolean[n][k + 1];
        
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
}
}