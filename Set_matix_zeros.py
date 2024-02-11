# 73.Set Matrix zeros
# Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
# Ex1:
# Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
# Output: [[1,0,1],[0,0,0],[1,0,1]]
# Ex2:
# Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
# Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        l=len(matrix)
        n=len(matrix[0])
        arr=[]
        
        for i in range(0,l):
            for j in range(0,n):
                if matrix[i][j]==0:
                    arr.append((i,j)) 
        for g,h in arr:
            matrix[g]=[0]*n
            for i in range(l):
                matrix[i][h]=0
    #(or)
  class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows = set()
        cols = set()
        """Loop through matrix and track rows and cols with zeros"""
        for row in range(len(matrix)):
            for col in range(len(matrix[row])):
                if matrix[row][col] == 0:
                    rows.add(row)
                    cols.add(col)
        """Loop through matrix again"""
        """Set zeros if row / col in sets from above"""
        for r in range(len(matrix)):
            for c in range(len(matrix[r])):
                if r in rows or c in cols:
                    matrix[r][c] = 0

    #java sol
