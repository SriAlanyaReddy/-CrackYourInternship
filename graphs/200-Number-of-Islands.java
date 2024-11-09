import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    // DFS function to explore the grid and record the shape of the island
    void dfs(int row, int col, int[][] visited, ArrayList<String> vec, int row0, int col0, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        vec.add(toString(row - row0, col - col0));
        
        // Direction vectors for moving up, left, down, and right
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];
            
            // Continue DFS if within bounds, unvisited, and part of the island ('1')
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m 
                && visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, visited, vec, row0, col0, grid);
            }
        }
    }

    // Helper function to format the relative coordinates as a string
    private String toString(int row, int col) {
        return row + \ \ + col;
    }

    // Main function to count distinct islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        
        ArrayList<ArrayList<String>> uniqueIslands = new ArrayList<>();
        int[][] visited = new int[n][m];
        
        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is unvisited and part of an island ('1')
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i, j, visited, shape, i, j, grid);
                    uniqueIslands.add(shape);
                }
            }
        }
        
        // The number of distinct islands is the size of the HashSet
        return uniqueIslands.size();
    }
}
