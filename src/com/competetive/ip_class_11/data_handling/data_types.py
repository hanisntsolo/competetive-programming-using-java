print("Hello World")

# 4.2 Data Types :
# 	4.2.1 Numbers
# 		4.2.1 A : Integers

num=-5
num2=10
num3=-1900000000000
print("First", num)
print("Second", num2)
print("Third", num3)
print(num, num2, num3) # To print on the same line
print("Data type of num is :: ", type(num))

print("*************************************")

print(str(20))
print(type(str(20)))
print(bool(1)) #True or False
print(bool(0)) #True or False
print("*************************************")
print(type(bool(10)))
print(bool(10)) #True or False 10 // 
"""	
				8421           //8 + 4 + 3 + 1 = 1		
0				0000	// False		
1               0001    // True
2               0010
3               0011
4               0100
10              1010

			
10 -------> 1010

"""

print("*************************************")
print((bool(234)))

# 4.2.1 B Floating Point NUmbers ::
	# 1. Fractional Form
"""               I    F
I = Integral Part
F = Fractional Part
5/2 = 4/2 + 1/2 = 2 + 1/2 = 2 + 0.5 = 2.5        
                 2 is integer part
				 5 is fractional part
"""
print("*************************************")
num=15.01
print(num)
print(type(num))

	# 2. Exponent Notation
print("*************************************")
num=7E3 # 7 * 10 ^ 3  
num=7E-3 # 7 * 10 ^ -3	
num=1.479101E02	#1.479101 * 10 ^ 2		# 10 ^ 3
print(num)
print(type(num))


# 4.2.2 Strings
print('**********************************')
name="rani"
nameRani="rani"
print(name)
print(type(name))

'''
Forward  indexing   0  1  2  3
				   "r  a  n  i"
Backward indexing  -4 -3 -2 -1

'''
print('**********************************')
print(name)
print(name[-2] == name[3]) #Relational Operator
# print(name[2])
print('**********************************')
#     0123456
name="VIBGYOR"

print(name[-3])
print(name[4])
print('**********************************')
# print(name[40])
print(name+nameRani)
print(name, nameRani)

# 4.2.3 List and Tuples

# List : 
	#4.2.3 A Lists
print('**********************************')
# A list can hold any data type
dict = {'k' : 10}
pyList = [1]
pyList[0] = dict
print(pyList)
print(type(pyList))
print(type(pyList[0]))
print('**********************************')
pyList[0] = "Mera Man"
print(pyList)
print(type(pyList)) # List
print(type(pyList[0])) # String
pyList.append(dict)
pyList.append([56])
pyList.append(1.4923840E-02)
pyList.append(True)
pyList.append((1,2,3))

print(pyList)
print(type(pyList[5]))
print("Getting id of :: pyList", id(pyList))
# 

     #4.2.4
     #Dictionary

D={'kajal':'singh'}
print(D)
print((D['kajal']))
print('**********************************')		
#Aadhaar # Total 125 Cr janta
aadhar = {
	989212352946 : {
		'name' : 'Dhirendra Pratap Singh',
		'dob' : "03-09-97",
		'address' : 'gonwa',
		'parents' : 'parentName',
		'photograph' : 'photo.png'
	},
	352946989212 : {
		'name' : 'Sweta Singh',
		'dob' : "20-12-04",
		'address' : 'gonwa',
		'parents' : 'parentName',
		'photograph' : 'photo1.png'
	},
	352946989213 : {
		'name' : 'Kajal Singh',
		'dob' : "01-02-02",
		'address' : ['gonwa'],
		'parents' : 'parentName',
		'photograph' : 'photo3.png'
	}
}
print(aadhar)
print('**********************************')	
print(aadhar[989212352946])
print('**********************************')	
print(aadhar[352946989213])

#Address Update for Kajal
# aadhar[352946989213].'address'
print(aadhar[352946989213]['address'])
print(type(aadhar[352946989213]['address']))
print('***************Address Update*******************')	
# aadhar[352946989213]['address'].append("A2 Kumar Pebble Park Handewadi Rd Hadapsar, Pune 411028")

print(aadhar[352946989213])
print('***************Address Remove Gonwa Update*******************')	
aadhar[352946989213]['address'][0]="A2 Kumar Pebble Park Handewadi Rd Hadapsar, Pune 411028"

print(aadhar[352946989213])

# Very Important Concept : 
#Immutable and Mutable types : 
	# Immutable
		# : Memory Location cannot be modified with new value
			# int, float, tuple, bool, str
	# Mutable
		# : Memory Location can be modified with new value
			# : list, dict, sets
print('**************Immutable Types********************')	
print(id(5))
a = 5
print("id a ::", id(a))
p = a
print("id p ::", id(p))
b = 5
print("id b ::", id(b))
q = b
print("id q ::", id(q))
c = 5
print("id c ::", id(c))
print(id(5))
print(id(10))
print(id(5 + 5))
#
print(id(aadhar))
print((id(aadhar) == id(aadhar)))
# not, or, and 
print(id(aadhar[352946989213]['address']))





