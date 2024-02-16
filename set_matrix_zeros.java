// 73.Set Matrix zeros
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// Ex1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Ex2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

//brute force
class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int rows[]=new int[n];//after defining array will be filled with null values ofthat type
        int cols[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            if (rows[i]==1) {
                Arrays.fill(matrix[i],0);
            }
        }
        for(int i=0;i<m;i++){
            if (cols[i]==1){
            for(int j=0;j<n;j++){
                matrix[j][i]=0;
            }}
        }

    }
}
