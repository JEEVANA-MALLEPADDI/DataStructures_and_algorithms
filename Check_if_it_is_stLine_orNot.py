'''
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
Example
1:

Input: coordinates = [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7]]
Output: true
Example
2:

Input: coordinates = [[1, 1], [2, 2], [3, 4], [4, 5], [5, 6], [7, 7]]
Output: false
'''


'''
coordinates=[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]

coordinates.sort()
print(coordinates)
slopes=[]
n=len(coordinates)
for i in range(n-1):
    y2=coordinates[i+1][1]
    y1=coordinates[i][1]
    x2=coordinates[i+1][0]
    x1=coordinates[i][0]
    m=(y2-y1)/(x2-x1)   #when zeros it gives divided by zero error
    slopes.append(m)
slope=slopes[0]
if slopes.count(slope)==n-1:
    print("true")
else:
    print("false")

#(x-x1)(y2-y1)=(x2-x1)(y-y1)
'''
#other optimal sollution
class Solution:
    def checkStraightLine(self, coordinates):
        x0, y0 = coordinates[0]
        x1, y1 = coordinates[1]

        for i in range(2, len(coordinates)):
            x, y = coordinates[i]
            if (x - x0) * (y1 - y0) != (y - y0) * (x1 - x0):
                return False

        return True
