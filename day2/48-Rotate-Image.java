class Solution {
    public void rotate(int[][] a) {
        int n = a.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Step 2: Horizontal flip (swap columns within each row)
        for (int i = 0; i < n; i++) { // Iterate over rows
            for (int j = 0; j < n / 2; j++) { // Iterate over columns till the middle
                int t = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = t;
            }
        }
    }
}
