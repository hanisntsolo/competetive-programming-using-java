
"""  

  0  1  2  3  4
# M  A  D  A  M
 -5 -4 -3 -2 -1

0 - (i + 1)

  0  1  2  3  4  5
# M  A  D  D  A  M
 -6 -5 -4 -3 -2 -1 
 """
import math
s="AMAAAAAAAAAAAAAAAAAAAAMA"
notAPalindrome = False
for i in range(0, math.ceil(len(s)/2)):
	if s[i] != s[0 - (i + 1)]:
		print("Not a palindrome!")
		notAPalindrome = True
		break
if notAPalindrome == False:
	print("It is a palindrome!")