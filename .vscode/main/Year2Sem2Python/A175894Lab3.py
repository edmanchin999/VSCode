print("Lab 3: Condition & Loop statement and defining function")
print()
print("Question 1:")
print()
print("if-elif-else")
"""
number = int(input("Enter a number: "))

if number >= 22:
    print("if")
elif number >= 21:
    print("elif")
else:
    print("else")
"""

print()
print("b)")
print("colour.py")
"""
colour = input("Enter your favourite colour: ")

if colour == 'green':
    print("This is my favourite colour")
elif colour == 'blue':
    print("It is a nice colour but not my most favourite colour")
else:
    print("not my favourite colour")
"""

print()
print("While Loop")
print()
"""
count = 1

while count <= 10:
    print(count, end="")
    count += 1
"""

print()
print("squares.py")

"""
i = 1
square = 1

while i < 10:
    print(i, end=" ")
    print(square)
    i += 1
    square = i*i
"""

print("For Loops")
print("a)")
print()

for integer in range(10):
    print(integer, end=" ")

print()
integer2 = list(range(5))
print(integer2)
integer3 = list(range(1, 5))
print(integer3)
integer4 = list(range(1, 5, 2))
print(integer4)
print()

print("b)")
fruits = ['apple', 'orange', 'durian']
for fruit in fruits:
    print(fruits)

print()

num = [1, 2, 3]
squares = []
for n in num:
    squares.append(n**2)
print(squares)
print()

print("This is same as the above one")

num1 = [1, 2, 3]
squares1 = [n**2 for n in num1]
print(squares1)
print()

print("Defining Function")
print("a)")


def sign(num2):
    if num2 > 0:
        return 'positive'
    elif num2 < 0:
        return 'negative'
    else:
        return 'zero'


for x in [-1, 0, 1]:
    print(sign(x))

sign(1)
print()
print("b)")
print()


def welcome(name, loud=False):
    if loud:
        print('WELCOME,%s!' % name.upper())
    else:
        print('Welcome,%s' % name)


welcome('Jane')
welcome('John', loud=True)
