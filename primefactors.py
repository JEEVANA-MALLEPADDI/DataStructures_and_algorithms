# prime factors of a number when multiplied gives the original number
# def primeFactors(n):
#     arr=[]
#     for i in range(2,n+1):
#         if(isprime(i)):
#             x=i
#             while(n%x==0):
#                 arr.append(i)
#                 x=x*i
#     return arr
# print(primeFactors(12))
# print(primeFactors(13))
# print(primeFactors(315))

def primeFactors(n):
  arr=[]
  for i in range(2,int(n**0.5)+1):
     while(n%i==0):
       arr.append(i)
       n=n//10
  if(n>1):
    arr.append(n)



# more efficient than previous one
def primeFactors(n):
    arr = []
    while (n%2==0):
        arr.append(2)
        n = n // 2

    while (n%3==0):
        arr.append(3)
        n = n // 3

    for i in range(5, int(n ** 0.5), 6):
        while (n%i==0):
            arr.append(i)
            n = n // i
        while (n%(i+2)==0):
            arr.append(i+2)
            n = n // (i+2)
    if (n > 3):
        arr.append(n)
    return arr

print(primeFactors(12))
print(primeFactors(13))
print(primeFactors(315))
  
       
