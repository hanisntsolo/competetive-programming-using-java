print("1", "  ","2")

aDict = {
	'Ahavna' : 1,
	'Aichard' : 2,
	'Airoza' : 10,
	'Arshnoor' : 20
} 
temp = ' '
for key in aDict:
	print(temp, key)
	if temp < key:
		print("Changed", temp, key)
		temp = key
print(temp)