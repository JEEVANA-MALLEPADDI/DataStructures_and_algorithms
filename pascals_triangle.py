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


#another sol---------------------------------------------------------------------------------

from typing import *

def nCr(n, r):
    res = 1

    # calculating nCr:
    for i in range(r):
        res = res * (n - i)
        res = res // (i + 1)
    return int(res)

def pascalTriangle(n : int) -> List[List[int]]:
    ans = []

    #Store the entire pascal's triangle:
    for row in range(1, n+1):
        tempLst = [] # temporary list
        for col in range(1, row+1):
            tempLst.append(nCr(row - 1, col - 1))
        ans.append(tempLst)
    return ans

if __name__ == '__main__':
    n = 5
    ans = pascalTriangle(n)
    for it in ans:
        for ele in it:
            print(ele, end=" ")
        print()

#Time Complexity: O(n*n*r) ~ O(n3), where n = number of rows, and r = column index.
#Reason: The row loop will run for approximately n times. And generating a row using the naive approach of variation 2 takes O(n*r) time complexity.
#Space Complexity: In this case, we are only using space to store the answer. That is why space complexity can be still considered as O(1).
