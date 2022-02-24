print("Name: Chin Jian Jie")
print("Matric Number: A175894")
print("Lab Task 4")


def printOutput(N, timeOfTurns):
    numbers = N - 1
    status = True
    result = timeOfTurns
    res = numbers
    while(res > 0 and status):
        if(res % 10 == 3 or res % 10 == 7):  # condition for 3 or 7
            status = False
        res = res//10

    if(not status):  # status is false
        print(numbers, end=" ")
        result = result*numbers  # do multiplication

    if(N > 1):
        printOutput(numbers, result)  # recursive
    else:
        print("\nThe Final product is: ", result)


inputForUser = int(input("Please enter a value: "))
printOutput(inputForUser, 1)
