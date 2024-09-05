import java.util.*;
import java.io.*;

public class Solution {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        return choco(grid, 0, 0, c - 1);
    }

    public static int choco(int[][] grid, int i, int j1, int j2) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Base case: If we're at the last row
        if (i == rows - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        int maxi = Integer.MIN_VALUE;
        int[] dj = {-1, 0, 1};  // Possible moves for columns

        // Explore all possible movements
        for (int dj1 : dj) {
            for (int dj2 : dj) {
                int newJ1 = j1 + dj1;
                int newJ2 = j2 + dj2;

                // Ensure indices are within bounds
                if (newJ1 >= 0 && newJ1 < cols && newJ2 >= 0 && newJ2 < cols) {
                    int currentValue;
                    if (j1 == j2) {
                        currentValue = grid[i][j1] + choco(grid, i + 1, newJ1, newJ2);
                    } else {
                        currentValue = grid[i][j1] + grid[i][j2] + choco(grid, i + 1, newJ1, newJ2);
                    }
                    maxi = Math.max(maxi, currentValue);
                }
            }
        }

        return maxi;
    }
}
