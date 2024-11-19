class Solution {
    public int getMaximumGold(int[][] grid) {
         int maxGold = 0;
        int m = grid.length;
        int n = grid[0].length;

        // Traverse each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) { // Start DFS only from cells with gold
                    maxGold = Math.max(maxGold, collectGold(grid, i, j));
                }
            }
        }

        return maxGold;
    }
    public int collectGold(int[][] grid,int i,int j){
         if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int currentGold = grid[i][j];
        grid[i][j] = 0; // Mark the cell as visited

        // Explore all four directions
        int maxGoldFromHere = Math.max(
            Math.max(collectGold(grid, i - 1, j), collectGold(grid, i + 1, j)),
            Math.max(collectGold(grid, i, j - 1), collectGold(grid, i, j + 1))
        );

        grid[i][j] = currentGold; // Backtrack to restore the original state

        return currentGold + maxGoldFromHere;

    }
}