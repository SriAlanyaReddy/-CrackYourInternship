import java.util.*; 
import java.io.*; 

public class Solution {
    public static boolean subsetSumToK(int n, int k, int a[]){
        // Initialize dp array as a boolean array
        boolean dp[][] = new boolean[n][k+1];
        
        // Fill the dp array with default false values
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], false);
        }
        
        // Call the recursive function to check for subset sum
        return sumEquals(n-1, k, a, dp);
    }

    public static boolean sumEquals(int ind, int target, int a[], boolean dp[][]){
        if(target == 0){
            return true;  // A subset with sum 0 is always possible (empty subset)
        }
        if(ind == 0){
            return a[ind] == target;  // Only one element left, check if it matches the target
        }
        
        if(dp[ind][target]){  // If dp[ind][target] is already computed, return the stored result
            return dp[ind][target];
        }
        
        // Recursive cases
        boolean notTake = sumEquals(ind - 1, target, a, dp);  // Option: not including the current element
        boolean take = false;
        
        if(target >= a[ind]){  // Option: include the current element, if it's <= target
            take = sumEquals(ind - 1, target - a[ind], a, dp);
        }
        
        // Store the result and return
       
        return dp[ind][target]=take || notTake;
    }
}//using memoization
