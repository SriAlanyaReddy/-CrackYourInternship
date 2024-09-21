import java.util.*; 
import java.io.*; 

public class Solution {
    public static boolean subsetSumToK(int n, int k, int a[]){
        // Initialize dp array as a boolean array
        boolean dp[][] = new boolean[n][k+1];
        
        // Base case: sum 0 is always possible (empty subset)
        for(int i = 0; i < n; i++){
            dp[i][0] = true; // Fill the first column with true
        }

        // Base case for the first element
        if(a[0] <= k) {
            dp[0][a[0]] = true;
        }
        
        // Build the dp array
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= k; j++){
                boolean notTake = dp[i-1][j]; // Not including the current element
                boolean take = false;
                if(a[i] <= j){
                    take = dp[i-1][j - a[i]]; // Including the current element
                }
                dp[i][j] = take || notTake;
            }
        }
        
        // Return the result for the full array and target sum k
        return dp[n-1][k];
    }
}
