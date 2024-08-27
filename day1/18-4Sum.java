import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);  // Sort the array to facilitate the two-pointer approach
        
        List<List<Integer>> output = new ArrayList<>();
       
        if (nums == null || nums.length < 4) {
            return output;  // Return an empty list if there aren't enough elements
        }
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicates for i
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  // Skip duplicates for j
                
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    long s = (long)nums[left] + nums[right] + nums[i] + nums[j];
                    
                    if (s == target) {
                        // Add the valid quadruplet to the output
                        output.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Skip duplicates for right
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (s < target) {
                        left++;  // Increase the sum by moving the left pointer to the right
                    } else {
                        right--;  // Decrease the sum by moving the right pointer to the left
                    }
                }
            }
        }
        
        return output;
    }
}
