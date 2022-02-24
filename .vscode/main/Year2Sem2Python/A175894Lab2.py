print('Lab 2  Data Structure')
print()

print('Question 1: List')
print('Section 1')
s = [5, 6, 7]
print(s, s[2])
print(s[-2])
s[1] = 'foo'
print(s)
s.append('bar')
xs = s.pop()
print('\n')


print('Section 2')
s = list(range(5))
print(s)
print(s[:])
print(s[1:3])
print(s[:3])
print(s[3:])
print()

print('Section 3')
s = 5*[10]
s[0] += 5
print(s)
print()

print('Section 4')
s = ['']*3
s[2] += 'a'
print(s)
print()

print('Section 5')
s = [[]] * 4
s[0] = [4, 1]
print(s)
print()


print('Question 2')
print()

thisisTuple = ('Jane', '23', 'Female')
print(thisisTuple)
print()

print('Method 1: Create a new tuple')
thisisANewTuple = thisisTuple[:1] + thisisTuple[2:]
print(thisisANewTuple)
print()

print('Method 2: Casting the tuple to a list')
thisisList = list(thisisTuple)
thisisList.pop(1)
print(thisisList)
print()

print('Question 3: Dictionary')
thisisADictionary = {'someItem': 2, 'otherItem': 20}
print(thisisADictionary['otherItem'])
thisisADictionary['newItem'] = 200
print(thisisADictionary['newItem'])
print()

print('Question 4:Set')
print()

SetNo1 = {"Postcard", "Radio", "Telegram"}
print(SetNo1)
SetNo2 = {"A Python Tutorial"}
print(SetNo2)
SetNo3 = {set["Perl", "Python", "Java"]}
print(SetNo3)
SetNo4 = set(("Apple", "Orange", "Pear", "Pineapple", "Apple", "Lemon"))
print(SetNo4)
SetNo5 = set((["Apple", "Orange", "Pear", "Pineapple"], ["Perl", "Python"]))
print(SetNo5)
