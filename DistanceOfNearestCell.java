// Distance of nearest cell having 1
// Difficulty: Medium Average Time: 20m
// Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
// The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the 
// current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.

// Examples

// Input: 
// grid = [[0,1,1,0], [1,1,0,0], [0,0,1,1]]
// Output: 
// [[1,0,0,1], [0,0,1,1], [1,1,0,0]]
// Explanation: 
// The grid is-
// 0 1 1 0 
// 1 1 0 0 
// 0 0 1 1 
// - 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.
 
// Input: 
// grid = [[1,0,1], [1,1,0], [1,0,0]]
// Output: 
// [[0,1,0], [0,0,1], [0,1,2]]
// Explanation: 
// The grid is-
// 1 0 1
// 1 1 0
// 1 0 0
// - 0's at (0,1), (1,2), (2,1) and (2,2) are at a  distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.
 
// Yout Task:
// You don't need to read or print anything, Your task is to complete the function nearest() which takes the grid as an input parameter 
// and returns a matrix of the same dimensions where the value at index (i, j) in the resultant matrix signifies the minimum distance of 1 in the matrix from grid[i][j].


class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] res=new int[n][m];
        
        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        //step 1 add 1's to the queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new int[] {i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        //step2 perform bfs
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        
        
        while(q.isEmpty()==false){
            int[] c=q.poll();
            int x=c[0];
            int y=c[1];
            int dist=c[2];
            res[x][y]=dist;
            for(int[] dir :dirs){
               int nx=x+dir[0];
               int ny=y+dir[1];
               if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]){
                   visited[nx][ny]=true;
                   q.offer(new int[]{nx,ny,dist+1});
               }
            }
        }
        return res;
    }
}
