# def isprime(n):
#     for i in range(2,int(n**0.5)+1):
#         if(n%i==0):
#             return False
#     return True
# print(isprime(13))
# print(isprime(91))

#more optimized sollution oof isprime
def isprime(n):
    if n <= 1:
        return False
    if n == 2 or n==3:
        return True
    if n % 2 == 0 or n%3==0:
        return False
    for i in range(5, int(n**0.5) + 1, 6):
        if n % i == 0 or n%(i+2)==0:
            return False
    return True

print(isprime(13))
print(isprime(36))
print(isprime(97))

