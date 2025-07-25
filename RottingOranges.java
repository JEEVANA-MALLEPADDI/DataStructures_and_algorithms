// 994. Rotting Oranges
// Medium

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

class Solution {
    public int orangesRotting(int[][] mat) {
        int fresh = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Count fresh oranges and enqueue rotten ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    fresh++;
                } else if (mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // If no fresh oranges, return 0
        if (fresh == 0) return 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;

        // BFS to spread rotting effect
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotHappened = false;

            for (int i = 0; i < size; i++) {
                int[] item = q.poll();
                int r = item[0], c = item[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && mat[newRow][newCol] == 1) {
                        mat[newRow][newCol] = 2; // Mark as rotten
                        fresh--;
                        q.offer(new int[]{newRow, newCol});
                        rotHappened = true;
                    }
                }
            }
            if (rotHappened) time++; // Increase time only if new oranges rot
        }

        return fresh == 0 ? time : -1; // Return -1 if some fresh oranges remain
    }
}









//more efficient





class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Count fresh oranges and add rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // {x, y, time}
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        // Step 2: BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], time = curr[2];
            minutes = Math.max(minutes, time);

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;  // rot the orange
                    fresh--;
                    queue.offer(new int[]{nx, ny, time + 1});
                }
            }
        }

        // Step 3: If fresh oranges remain, return -1
        return fresh == 0 ? minutes : -1;
    }
}
