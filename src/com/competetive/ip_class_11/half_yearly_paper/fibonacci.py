# n = int(input("Enter the number of terms you want :: "))
n = 7
"""# c = 1;
# range(0, n) // 0 - (n - 1)
# 0 1 2 3 4 5 6 7 .... .... n 
# i 0 // i?0 i+1?1
# i 1 // i?1 i+1?2
# i 2 // i?2 i+1?3


# i (n-1) // i?(n-1) i + 1 ? (n - 1) + 1
# 0 1 1 2 3 5 8 . . . . fibonacci series 
  # a b nn
  # nn = 1
  # nn = nn + b
  # 		1 + 1 nn = 2"""
# print("Jinda hun!", n)

# // Iterative Approach
"""

if n == 1:
	print(0)
elif n == 2:
	print(0, 1)
else:
	a = 0
	b = 1
	nextNumber = a + b #
	fibSeries = str(a) + " " + str(b) + " " + str(nextNumber)
	for i in range(2, n - 1):
		prevNumber = nextNumber
		nextNumber = b + nextNumber
		b = prevNumber
		fibSeries = fibSeries + " " + str(nextNumber)
	print(fibSeries)
"""
# dict
 # {
 # 	key : value
 # 	2 : 1
 # 	fib(1) : xyz
 # 	fib(2) : 
 # }
# // Recursive Approach
# //Memoized Approach
memo = {}
def fibonacci(num: int) -> int:
	if num < 2:
		return num
	if str(num) in memo:
		return memo[str(num)]
	cache =  fibonacci(num - 1) + fibonacci(num - 2)
	memo[str(num)] = cache
	return cache
# for i in range(0, 8):
# 	print(fibonacci(i), end=" ")

# Non memoized approach :
def f1(num : int) -> int:
	if num < 2:
		return num
	return f1(num - 1) + f1(num - 2)

#One - Liner
def f(num : int) -> int:
	return num if num < 2 else f(num - 1) + f(num - 2)

for i in range(0, 8):
	print(f(i), end=" ")





