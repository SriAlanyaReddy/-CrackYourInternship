import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Cell {
        int sr;
        int sc;

        Cell(int sr, int sc) {
            this.sr = sr;
            this.sc = sc;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];

        // Base case: If the new color is the same as the original color, no work is needed.
        if (color == originalColor) {
            return image;
        }

        // Initialize the starting cell.
        image[sr][sc] = color;
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(sr, sc));

        // Direction arrays for moving up, down, left, and right.
        int[] dirx = {-1, 1, 0, 0};
        int[] diry = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Cell current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.sr + dirx[i];
                int ny = current.sc + diry[i];

                // Check bounds and if the cell matches the original color.
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && image[nx][ny] == originalColor && image[nx][ny]!=color) {
                    image[nx][ny] = color; // Update the color.
                    q.offer(new Cell(nx, ny)); // Add to the queue for further processing.
                }
            }
        }

        return image; // Return the updated image after BFS traversal.
    }
}
