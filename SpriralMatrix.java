// 54. Spiral Matrix

// Medium

// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:


// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int left=0;
        int right=matrix[0].length;
        int top=0;
        int bottom=matrix.length;
        while(left<right && top<bottom){
            for(int i=left;i<right;i++){
                res.add(matrix[top][i]);
            }
            top+=1;
            for(int i=top;i<bottom;i++){
                res.add(matrix[i][right-1]);
            }
            right-=1;
            if(left>=right || top>=bottom) break;

            for(int i=right-1;i>left-1;i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom-=1;
            for(int i=bottom-1;i>top-1;i--){
                res.add(matrix[i][left]);
            }
            left+=1;
        }
        return res;
    }
}//time complexity O(m*n)
