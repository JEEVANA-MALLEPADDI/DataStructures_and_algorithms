# Given an array arr of non-negative numbers. The task is to find the first equilibrium point in an array. The equilibrium point in an array is an index (or position) such that the sum of all elements before that index is the same as the sum of elements after it.

# Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

# Examples:

# Input: arr[] = [1, 3, 5, 2, 2]
# Output: 3 
# Explanation: The equilibrium point is at position 3 as the sum of elements before it (1+3) = sum of elements after it (2+2). 
# Input: arr[] = [1]
# Output: 1
# Explanation: Since there's only one element hence it's only the equilibrium point.
# Input: n = 3, arr[] = [1, 2, 3]
# Output: -1
# Explanation: There is no equilibrium point in the given array.
# Expected Time Complexity: O(n)
# Expected Auxiliary Space: O(1)

# Constraints:
# 1 <= arr.size <= 105
# 0 <= arr[i] <= 109

class Solution:
    # Complete this function
    #Function to find equilibrium point in the array.
   
    def equilibriumPoint(self,arr):
        # Your code here
        l=len(arr)
        if(l==1):
          return 1
        elif(l==0):
            return -1
        else:
            a=[]
            b=[]
            sl=0
            sr=0
            for i in range(l):
                a.append(sl)
                sl=sl+arr[i]
                b.append(sr)
                sr=sr+arr[l-1-i]
                
            b.reverse()
            for i in range(l):
                if(a[i]==b[i]):
                    return i+1
        return -1


##optimumm sollution
class Solution:

    #Function to find equilibrium point in the array.
    def equilibriumPoint(self, arr):
        n = len(arr)
        #We store the sum of all array elements.
        sum = 0
        for i in range(0, n):
            sum += arr[i]

        #sum2 is used to store prefix sum.
        sum2 = 0

        for i in range(0, n, +1):

            #Leaving out the value of current element from suffix sum.
            sum -= arr[i]

            #Checking if suffix and prefix sums are same.
            if sum2 == sum:
                #returning the index or equilibrium point.
                return (i + 1)

            #Adding the value of current element to prefix sum.
            sum2 += arr[i]

        return -1
