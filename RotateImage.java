// 48. Rotate Image
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:
   1  2   3
   4  5   6
   7  8   9

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]


// Example 2:
     5   1   9   11
     2   4   8   10
    13   3   6    7
    15  14   12  16

// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]



     class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //step 1 transpose the matrix
        for (int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;

            }
        }//time complexity =>  O(n/2 * n/2)
        //reverse each row in the transposed matrix
        for(int i=0;i<n;i++){
            int s=0;
            int l=n-1;
            while(s<l){
                int temp=matrix[i][s];
                matrix[i][s]=matrix[i][l];
                matrix[i][l]=temp;
                s++;
                l--;
            }
        }//time complexity=>  O(n * n/2)
        
    }
  
}
