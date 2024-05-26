dict = {
	"abc" : 5,
	"def" : 6,
	"ghi" : 7,
	"del" : 10
}
print(dict['abc'])
print('Before Update : ', dict) 
dict.update({"abc" : 10, "ghi" : 500})
print(dict)
print('After Update : ', dict)