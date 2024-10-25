class Solution {
    public int maxProduct(int[] nums) {
        // Initialize two variables to hold the largest and second-largest numbers
        int max1 = 0, max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1; // Update second largest
                max1 = num;  // Update largest
            } else if (num > max2) {
                max2 = num;  // Update second largest if the current number is less than max1 but greater than max2
            }
        }

        // Return the product of (max1 - 1) and (max2 - 1)
        return (max1 - 1) * (max2 - 1);
    }
}
