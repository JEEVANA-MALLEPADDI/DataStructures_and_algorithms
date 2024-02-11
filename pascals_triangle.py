# 118.pascals triangle
# Given an integer numRows, return the first numRows of Pascal's triangle.
# 1
# 121
# 1331
# 14641
# Example 1:

# Input: numRows = 5
# Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
# Example 2:

# Input: numRows = 1
# Output: [[1]]



class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        arr=[[1]]
        for i in range(1,numRows):
            r=[1,1]
            for j in range(1,i):
                a=arr[-1][j-1]+arr[-1][j]
                r.insert(j,a)
            arr.append(r)

        return arr



#(or)





class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows <= 0:
            return []
        triangle = []
        for i in range(numRows):
            row = [1] * (i+1)
            if i >= 2:
                for j in range(1, i):
                    row[j] = triangle[i - 1][j-1] + triangle[i-1][j]
            triangle.append(row)
        return triangle
