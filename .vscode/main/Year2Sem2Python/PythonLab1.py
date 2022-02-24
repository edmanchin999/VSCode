# This is my first lab for the python
# Name : Chin Jian Jie
# Matric Number: A175894

# Question 1  - Comment
print('---------Question 1------------')
print("This is a not a comment")
#print("This is a comment")

"""
print("This is a comment")
print("This is still a comment")
"""


print("This is not a comment")


# Question 2  - Variable
print('--------Question 2-------------')
x = 5
y = 10
print(x+y)

a = "5"
b = "10"

print(a + b)

c = "5"
d = 10
print(int(c)+d)


# Question 3 - Hello World
print('-----------Question 3------------')
print('Hello World!')

# Question 4 - Let's go more in depth into Strings
print('------------Question 4-----------------')
myStr = ""
print(type(myStr))

e = "String"
print(e[1:4])
print(e[:-1])
print(e.count('1'))
print(e.find('1'))
print(e.lower())
print(e.upper())
print(e.replace('i', 'u'))
print(e.strip())

# Question 5 - Print a pattern
print('---------------Question 5---------------')
f = "|".join(['*']*5)
g = '{}'.format('*'*9)

for i in range(0, 5):
    if (i % 2) == 0:
        print(f)
    else:
        print(g)


# Question 6: Super Pattern
print('------------------Question 6---------------')
h = ' H '.join(['*|*|*|*|*']*3) + '\n'
i = ' H '.join(['*********']*3) + '\n'
k = '+'.join(['='*10]*3) + '\n'
l = i.join([h]*3)
print(l, l, k)

# Question 7:
